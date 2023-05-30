package com.project.FlipCommerce.Dto.ResDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemResDto {
 int quantityAdded;

  String productName;

  int price;

}
