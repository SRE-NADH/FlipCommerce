package com.project.FlipCommerce.Dto.ReqDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerReqDto {
    String name;

    String email;

    String mobNo;
}
