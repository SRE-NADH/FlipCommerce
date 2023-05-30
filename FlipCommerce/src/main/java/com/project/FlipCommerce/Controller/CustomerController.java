package com.project.FlipCommerce.Controller;

import com.project.FlipCommerce.Dto.ReqDto.CustomerReqDto;
import com.project.FlipCommerce.Dto.ResDto.CustomerResDto;
import com.project.FlipCommerce.Model.Customer;
import com.project.FlipCommerce.Service.imp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flipcommerce/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImp customerServiceImp;
    @PostMapping("/add")
    public ResponseEntity AddCustomer(@RequestBody CustomerReqDto customerReqDto){
        CustomerResDto customerResDto = customerServiceImp.addCustomer(customerReqDto);
        return new ResponseEntity<>(customerResDto, HttpStatus.CREATED);
    }

}
