package com.project.FlipCommerce.Transformer;

import com.project.FlipCommerce.Dto.ResDto.CartResDto;
import com.project.FlipCommerce.Dto.ResDto.ItemResDto;
import com.project.FlipCommerce.Model.Cart;
import com.project.FlipCommerce.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class CartTransformer {

    public static CartResDto CartToRes(Cart cart) {

        List<ItemResDto> tmp = new ArrayList<>();
        for(Item item: cart.getItemList()){
            tmp.add(ItemTransformer.ItemToRes(item));
        }

        return CartResDto.builder().cartTotal(cart.getCartTotal()).customerName(cart.getCustomer().getName())
                .items(tmp).build();
    }
}
