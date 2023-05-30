package com.project.FlipCommerce.Service.imp;

import com.project.FlipCommerce.Dto.ReqDto.CheckOutCartDto;
import com.project.FlipCommerce.Dto.ReqDto.ItemReqDto;
import com.project.FlipCommerce.Dto.ResDto.CartResDto;
import com.project.FlipCommerce.Dto.ResDto.OrderResDto;
import com.project.FlipCommerce.Enum.ProductStatus;
import com.project.FlipCommerce.Exception.*;
import com.project.FlipCommerce.Model.*;
import com.project.FlipCommerce.Repocitory.*;
import com.project.FlipCommerce.Service.CartService;

import com.project.FlipCommerce.Transformer.CartTransformer;
import com.project.FlipCommerce.Transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    ItemServiceImp itemServiceImp;

    @Autowired
    CustomerRepocitory customerRepocitory;
    @Autowired
    ProductRepocitory productRepocitory;

    @Autowired
    CartRepocitory cartRepocitory;

    @Autowired
    CardRepocitory cardRepocitory;

    @Autowired
    OrderServiceImp orderServiceImp;

    @Autowired
    OrderRepocitory orderRepocitory;


    @Override
    public CartResDto addToCart(ItemReqDto itemReqDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientProductException {

        Item item = itemServiceImp.buildItem(itemReqDto);
        Customer customer = customerRepocitory.findByEmail(itemReqDto.getCustomerEmail());
        Product product = productRepocitory.findById(itemReqDto.getProductId()).get();
        Cart cart = customer.getCart();
        cart.setCartTotal(cart.getCartTotal()+(item.getRequiredQuantity()*product.getPrice()));
        cart.getItemList().add(item);
        item.setCart(cart);
        item.setProduct(product);
        Cart savedCart = cartRepocitory.save(cart);
        product.getItemList().add(item);
        return CartTransformer.CartToRes(savedCart); // save cart,item
    }

    @Override
    public OrderResDto CheckoutCart(CheckOutCartDto checkOutCartDto) throws CustomerNotFoundException, IncorrectCardDetailsException, InsufficientProductException, CartEmptyException {
        Customer customer = customerRepocitory.findByEmail(checkOutCartDto.getEmail());
        if(customer==null){
            throw  new CustomerNotFoundException("invalid email");
        }
        Card card = cardRepocitory.findByCardNo(checkOutCartDto.getCardNo());
        Date date= new Date();
        if(card==null || card.getCvv()!=checkOutCartDto.getCvv() ||date.after(card.getValidTill())){
            throw new IncorrectCardDetailsException("incorrect card details");
        }
        Cart cart = customer.getCart();
        if(cart.getItemList().isEmpty()){
            throw new CartEmptyException("cart is empty");
        }
        List<Item> itemList = cart.getItemList();
        HashMap<Product,Integer> hm = new HashMap<>();

        for(Item item: itemList){  // put product and their required Quantity into HashMap
            Product product = item.getProduct();
            hm.put(product,hm.getOrDefault(product,0)+item.getRequiredQuantity());
        }
        // check for Exception
        for(Product product:hm.keySet()){
           if(hm.get(product)>product.getQuantity()){
               throw new InsufficientProductException(" insufficient product");
           }
        }

        // if there is no exception change product quantity
        for(Item item:itemList){
            Product product=item.getProduct();
            product.setQuantity(product.getQuantity()-item.getRequiredQuantity());
            if(product.getQuantity()==0){
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
            }
        }
            OrderEntity orderEntity = orderServiceImp.PlaceOrder(cart,card);
             resetCart(cart);
            OrderEntity savedorder=orderRepocitory.save(orderEntity);
            return OrderTransformer.OrderToRes(savedorder);
    }

    private void resetCart(Cart cart) {
        cart.setCartTotal(0);
        for(Item item:cart.getItemList()){
            item.setCart(null);
        }
       cart.setItemList(new ArrayList<>());
    }
}
