package com.project.FlipCommerce.Service;

import com.project.FlipCommerce.Dto.ReqDto.OrderReqDto;
import com.project.FlipCommerce.Dto.ResDto.OrderResDto;
import com.project.FlipCommerce.Exception.CustomerNotFoundException;
import com.project.FlipCommerce.Exception.IncorrectCardDetailsException;
import com.project.FlipCommerce.Exception.InsufficientProductException;
import com.project.FlipCommerce.Exception.ProductNotFoundException;
import com.project.FlipCommerce.Model.Card;
import com.project.FlipCommerce.Model.Cart;
import com.project.FlipCommerce.Model.OrderEntity;

public interface OrderService {
    OrderResDto PlaceOrder(OrderReqDto orderReqDto) throws CustomerNotFoundException, InsufficientProductException, ProductNotFoundException, IncorrectCardDetailsException;

    OrderEntity PlaceOrder(Cart cart, Card card);
}
