package com.project.FlipCommerce.Controller;

import com.project.FlipCommerce.Dto.ReqDto.OrderReqDto;
import com.project.FlipCommerce.Dto.ResDto.OrderResDto;
import com.project.FlipCommerce.Service.OrderService;
import com.project.FlipCommerce.Service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flipcommerce")
public class OrderController {
    @Autowired
    OrderServiceImp orderServiceImp;

    @PostMapping("/placeorder")
    public ResponseEntity PlaceOrder(@RequestBody OrderReqDto orderReqDto) {
        try {
            OrderResDto orderResDto = orderServiceImp.PlaceOrder(orderReqDto);
            return new ResponseEntity<>(orderResDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
