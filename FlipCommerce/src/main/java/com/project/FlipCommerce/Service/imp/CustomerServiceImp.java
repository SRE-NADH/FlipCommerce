package com.project.FlipCommerce.Service.imp;

import com.project.FlipCommerce.Dto.ReqDto.CustomerReqDto;
import com.project.FlipCommerce.Dto.ResDto.CustomerResDto;
import com.project.FlipCommerce.Model.Cart;
import com.project.FlipCommerce.Model.Customer;
import com.project.FlipCommerce.Repocitory.CustomerRepocitory;
import com.project.FlipCommerce.Service.CustomerService;
import com.project.FlipCommerce.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepocitory customerRepocitory;
    @Override
    public CustomerResDto addCustomer(CustomerReqDto customerReqDto) {
        Customer customer = CustomerTransformer.ReqToCustomer(customerReqDto);
        Cart cart =Cart.builder().cartTotal(0).customer(customer).build();
        customer.setCart(cart);
        Customer savedCustomer = customerRepocitory.save(customer);
        String message = "customer addad Sccessfully";
        return  CustomerTransformer.CustomerToRes(savedCustomer,message);
    }
}
