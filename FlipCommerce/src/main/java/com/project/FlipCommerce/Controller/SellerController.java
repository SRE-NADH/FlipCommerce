package com.project.FlipCommerce.Controller;

import com.project.FlipCommerce.Dto.ReqDto.SellerReqDto;
import com.project.FlipCommerce.Dto.ResDto.SellerResDto;
import com.project.FlipCommerce.Service.SellerService;
import com.project.FlipCommerce.Service.imp.SellerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flipcommerce/seller")
public class SellerController {
    @Autowired
    SellerServiceImp sellerServiceImp;
    @PostMapping("/addSeller")
    public ResponseEntity addSeller(@RequestBody SellerReqDto sellerReqDto){
        SellerResDto sellerResDto=sellerServiceImp.addSeller(sellerReqDto);
        return new ResponseEntity(sellerResDto, HttpStatus.CREATED);
    }

}
