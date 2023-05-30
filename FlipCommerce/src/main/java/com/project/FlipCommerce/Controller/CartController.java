package com.project.FlipCommerce.Controller;

import com.project.FlipCommerce.Dto.ReqDto.CheckOutCartDto;
import com.project.FlipCommerce.Dto.ReqDto.ItemReqDto;
import com.project.FlipCommerce.Dto.ResDto.CartResDto;
import com.project.FlipCommerce.Dto.ResDto.OrderResDto;
import com.project.FlipCommerce.Service.CartService;
import com.project.FlipCommerce.Service.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flipcommerce/cart")
public class CartController {

    @Autowired
    CartServiceImp cartServiceImp;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemReqDto itemReqDto){
      try {
          CartResDto cartResDto = cartServiceImp.addToCart(itemReqDto);
          return new ResponseEntity(cartResDto, HttpStatus.ACCEPTED);
      }
      catch (Exception e){
          return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
      }
    }

    @PostMapping("/checkout")
    public ResponseEntity CheckoutCart(@RequestBody CheckOutCartDto checkOutCartDto){
        try {
            OrderResDto orderResDto = cartServiceImp.CheckoutCart(checkOutCartDto);
            return  new ResponseEntity<>(orderResDto,HttpStatus.CREATED);
        }
        catch (Exception e){
            return  new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
