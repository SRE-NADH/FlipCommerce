package com.project.FlipCommerce.Service.imp;

import com.project.FlipCommerce.Dto.ReqDto.SellerReqDto;
import com.project.FlipCommerce.Dto.ResDto.SellerResDto;
import com.project.FlipCommerce.Model.Seller;
import com.project.FlipCommerce.Repocitory.SellerRepocitory;
import com.project.FlipCommerce.Service.SellerService;
import com.project.FlipCommerce.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImp implements SellerService {
    @Autowired
    SellerRepocitory sellerRepocitory;

    @Override
    public SellerResDto addSeller(SellerReqDto sellerReqDto) {
        Seller seller= SellerTransformer.ReqTOSeller(sellerReqDto);
        Seller savedSeller = sellerRepocitory.save(seller);
        String message = "seller added Successfully";
        return SellerTransformer.SellerToRes(savedSeller,message);
    }
}
