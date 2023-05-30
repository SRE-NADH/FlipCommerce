package com.project.FlipCommerce.Service;

import com.project.FlipCommerce.Dto.ReqDto.CheckOutCartDto;
import com.project.FlipCommerce.Dto.ReqDto.ItemReqDto;
import com.project.FlipCommerce.Dto.ResDto.CartResDto;
import com.project.FlipCommerce.Dto.ResDto.OrderResDto;
import com.project.FlipCommerce.Exception.*;

public interface CartService {
    CartResDto addToCart(ItemReqDto itemReqDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientProductException;

    OrderResDto CheckoutCart(CheckOutCartDto checkOutCartDto) throws CustomerNotFoundException, IncorrectCardDetailsException, InsufficientProductException, CartEmptyException;
}
