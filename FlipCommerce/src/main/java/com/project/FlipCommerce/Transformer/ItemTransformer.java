package com.project.FlipCommerce.Transformer;

import com.project.FlipCommerce.Dto.ReqDto.ItemReqDto;
import com.project.FlipCommerce.Dto.ResDto.ItemResDto;
import com.project.FlipCommerce.Model.Customer;
import com.project.FlipCommerce.Model.Item;
import com.project.FlipCommerce.Model.Product;

public class ItemTransformer {

    public static Item ReqToItem(int Quantity) {
        return Item.builder().requiredQuantity(Quantity).build();
    }

    public static ItemResDto ItemToRes(Item item) {
        return ItemResDto.builder().price(item.getProduct().getPrice()).productName(item.getProduct().getName())
                .quantityAdded(item.getRequiredQuantity()).build();
    }
}
