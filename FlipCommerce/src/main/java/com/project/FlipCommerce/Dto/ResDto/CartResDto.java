package com.project.FlipCommerce.Dto.ResDto;

import com.project.FlipCommerce.Model.Item;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResDto {

    int cartTotal;

    List<ItemResDto> items;

    String customerName;
}
