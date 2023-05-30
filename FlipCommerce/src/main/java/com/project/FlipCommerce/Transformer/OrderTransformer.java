package com.project.FlipCommerce.Transformer;

import com.project.FlipCommerce.Dto.ReqDto.OrderReqDto;
import com.project.FlipCommerce.Dto.ResDto.ItemResDto;
import com.project.FlipCommerce.Dto.ResDto.OrderResDto;
import com.project.FlipCommerce.Model.Customer;
import com.project.FlipCommerce.Model.Item;
import com.project.FlipCommerce.Model.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransformer {
    public static OrderEntity ReqToOrder(Customer customer) {
        return OrderEntity.builder().orderNo(String.valueOf(UUID.randomUUID())).customer(customer)
                .itemList(new ArrayList<>()).build();
    }

    public static OrderResDto OrderToRes(OrderEntity savedOrder) {
        List<ItemResDto> tmp = new ArrayList<>();
        for(Item item:savedOrder.getItemList()){
            tmp.add(ItemTransformer.ItemToRes(item));
        }
        return OrderResDto.builder().orderNo(savedOrder.getOrderNo()).orderDate(savedOrder.getOrderDate())
                .cardUsed(savedOrder.getCardUsed()).customerName(savedOrder.getCustomer().getName())
                .itemList(tmp).totalValue(savedOrder.getTotalValue()).build();
    }
}
