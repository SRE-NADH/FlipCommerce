package com.project.FlipCommerce.Dto.ReqDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemReqDto {

    String customerEmail;

    int productId;

    int requierdQuantity;
}
