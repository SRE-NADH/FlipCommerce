package com.project.FlipCommerce.Transformer;

import com.project.FlipCommerce.Dto.ReqDto.SellerReqDto;
import com.project.FlipCommerce.Dto.ResDto.SellerResDto;
import com.project.FlipCommerce.Model.Seller;

public class SellerTransformer {

    public static Seller ReqTOSeller(SellerReqDto sellerReqDto) {
        return Seller.builder().name(sellerReqDto.getName()).email(sellerReqDto.getEmail())
                .mobNo(sellerReqDto.getMobNo()).build();
    }
    public static SellerResDto SellerToRes(Seller savedSeller,String message) {
        return SellerResDto.builder().name(savedSeller.getName()).messsage(message).build();
    }
}
