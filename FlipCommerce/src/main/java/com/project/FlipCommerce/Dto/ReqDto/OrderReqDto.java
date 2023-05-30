package com.project.FlipCommerce.Dto.ReqDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderReqDto {
    String email;

    String cardNo;

    int cvv;

    int quantity;

    int productId;
}
