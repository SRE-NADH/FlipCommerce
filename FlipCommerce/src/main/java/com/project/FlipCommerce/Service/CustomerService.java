package com.project.FlipCommerce.Service;

import com.project.FlipCommerce.Dto.ReqDto.CustomerReqDto;
import com.project.FlipCommerce.Dto.ResDto.CustomerResDto;

public interface CustomerService {
    CustomerResDto addCustomer(CustomerReqDto customerReqDto);
}
