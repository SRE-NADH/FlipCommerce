package com.project.FlipCommerce.Service;

import com.project.FlipCommerce.Dto.ReqDto.SellerReqDto;
import com.project.FlipCommerce.Dto.ResDto.SellerResDto;

public interface SellerService {

    SellerResDto addSeller(SellerReqDto sellerReqDto);
}
