package com.project.FlipCommerce.Transformer;

import com.project.FlipCommerce.Dto.ReqDto.CustomerReqDto;
import com.project.FlipCommerce.Dto.ResDto.CustomerResDto;
import com.project.FlipCommerce.Model.Customer;

public class CustomerTransformer {

    public static Customer ReqToCustomer(CustomerReqDto customerReqDto) {
        return Customer.builder().mobNo(customerReqDto.getMobNo()).name(customerReqDto.getName())
                .email(customerReqDto.getEmail()).gender(customerReqDto.getGender())
                .build();
    }

    public static CustomerResDto CustomerToRes(Customer savedCustomer,String msg) {
        return CustomerResDto.builder().email(savedCustomer.getEmail()).name(savedCustomer.getName())
                .message(msg).build();
    }
}
