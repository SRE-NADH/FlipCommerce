package com.project.FlipCommerce.Service.imp;

import com.project.FlipCommerce.Dto.ReqDto.ItemReqDto;
import com.project.FlipCommerce.Exception.CustomerNotFoundException;
import com.project.FlipCommerce.Exception.InsufficientProductException;
import com.project.FlipCommerce.Exception.ProductNotFoundException;
import com.project.FlipCommerce.Model.Card;
import com.project.FlipCommerce.Model.Customer;
import com.project.FlipCommerce.Model.Item;
import com.project.FlipCommerce.Model.Product;
import com.project.FlipCommerce.Repocitory.CustomerRepocitory;
import com.project.FlipCommerce.Repocitory.ProductRepocitory;
import com.project.FlipCommerce.Service.ItemService;
import com.project.FlipCommerce.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {
    @Autowired
    CustomerRepocitory customerRepocitory;
    @Autowired
    ProductRepocitory productRepocitory;

    @Override
    public Item buildItem(ItemReqDto itemReqDto) throws InsufficientProductException, CustomerNotFoundException, ProductNotFoundException {
        Customer customer = customerRepocitory.findByEmail(itemReqDto.getCustomerEmail());
        if(customer==null){
            throw  new CustomerNotFoundException("customer not found");
        }
        Optional<Product> optionalProduct = productRepocitory.findById(itemReqDto.getProductId());
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("invalid Id");
        }
        Product product= optionalProduct.get();
        if(product.getQuantity()==0){
            throw new InsufficientProductException("product out of stock");
        }
        if(itemReqDto.getRequierdQuantity()> product.getQuantity()){
            throw new InsufficientProductException("insufficient product");
        }
        return ItemTransformer.ReqToItem(itemReqDto.getRequierdQuantity());
    }
}
