package com.project.FlipCommerce.Service.imp;

import com.project.FlipCommerce.Dto.ReqDto.ItemReqDto;
import com.project.FlipCommerce.Dto.ReqDto.OrderReqDto;
import com.project.FlipCommerce.Dto.ResDto.OrderResDto;
import com.project.FlipCommerce.Enum.ProductStatus;
import com.project.FlipCommerce.Exception.CustomerNotFoundException;
import com.project.FlipCommerce.Exception.IncorrectCardDetailsException;
import com.project.FlipCommerce.Exception.InsufficientProductException;
import com.project.FlipCommerce.Exception.ProductNotFoundException;
import com.project.FlipCommerce.Model.*;
import com.project.FlipCommerce.Repocitory.CardRepocitory;
import com.project.FlipCommerce.Repocitory.CustomerRepocitory;
import com.project.FlipCommerce.Repocitory.OrderRepocitory;
import com.project.FlipCommerce.Repocitory.ProductRepocitory;
import com.project.FlipCommerce.Service.OrderService;
import com.project.FlipCommerce.Transformer.CardTransformer;
import com.project.FlipCommerce.Transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    CustomerRepocitory customerRepocitory;

    @Autowired
    ItemServiceImp itemServiceImp;

    @Autowired
    CardRepocitory cardRepocitory;

    @Autowired
    ProductRepocitory productRepocitory;

    @Autowired
    OrderRepocitory orderRepocitory;


    @Override
    public OrderResDto PlaceOrder(OrderReqDto orderReqDto) throws CustomerNotFoundException, InsufficientProductException, ProductNotFoundException, IncorrectCardDetailsException {

        ItemReqDto itemReqDto = ItemReqDto.builder().productId(orderReqDto.getProductId())
                .requierdQuantity(orderReqDto.getQuantity()).customerEmail(orderReqDto.getEmail())
                .build();
         Item item =  itemServiceImp.buildItem(itemReqDto);

        Card card = cardRepocitory.findByCardNo(orderReqDto.getCardNo());
        Date date= new Date();
        if(card==null || card.getCvv()!=orderReqDto.getCvv() ||date.after(card.getValidTill())){
             throw new IncorrectCardDetailsException("incorrect card details");
        }

        Customer customer = customerRepocitory.findByEmail(orderReqDto.getEmail());
        Product product = productRepocitory.findById(orderReqDto.getProductId()).get();

        product.setQuantity(product.getQuantity()-orderReqDto.getQuantity());
        if(product.getQuantity()==0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }
        item.setProduct(product);// set product in item

        OrderEntity orderEntity = OrderTransformer.ReqToOrder(customer); // set customer and orderNo

         int total = product.getPrice()*orderReqDto.
                 getQuantity();

         orderEntity.setTotalValue(total); // set total

         String cardUsed = CardTransformer.MaskedCardNo(card);
          orderEntity.setCardUsed(cardUsed); // set card used

        orderEntity.getItemList().add(item); // add item
        item.setOrderEntity(orderEntity);
        OrderEntity savedOrder = orderRepocitory.save(orderEntity);

        customer.getOrderEntityList().add(savedOrder);

        product.getItemList().add(savedOrder.getItemList().get(0));

        return OrderTransformer.OrderToRes(savedOrder);

    }

    @Override
    public OrderEntity PlaceOrder(Cart cart, Card card) {
        Customer customer = cart.getCustomer();
        OrderEntity orderEntity = OrderTransformer.ReqToOrder(customer);

        orderEntity.setTotalValue(cart.getCartTotal());

        String cardused = CardTransformer.MaskedCardNo(card);
        orderEntity.setCardUsed(cardused);

        orderEntity.setItemList(cart.getItemList());

        orderEntity.setCustomer(cart.getCustomer());
        customer.getOrderEntityList().add(orderEntity);

        for(Item item:cart.getItemList()){
            item.setOrderEntity(orderEntity);
        }
         return orderEntity;

    }
}
