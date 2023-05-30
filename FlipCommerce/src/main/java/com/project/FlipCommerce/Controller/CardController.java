package com.project.FlipCommerce.Controller;

import com.project.FlipCommerce.Dto.ReqDto.CardReqDto;
import com.project.FlipCommerce.Dto.ResDto.CardResDto;
import com.project.FlipCommerce.Service.CardService;
import com.project.FlipCommerce.Service.imp.CardServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flipcommerce/card")
public class CardController {
    @Autowired
    CardServiceImp cardServiceImp ;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardReqDto cardReqDto){
        try {
            CardResDto cardResDto = cardServiceImp.addCard(cardReqDto);
            return new ResponseEntity<>(cardResDto, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
