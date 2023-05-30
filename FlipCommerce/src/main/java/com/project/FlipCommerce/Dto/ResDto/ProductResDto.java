package com.project.FlipCommerce.Dto.ResDto;

import com.project.FlipCommerce.Enum.Category;
import com.project.FlipCommerce.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResDto {
    String sellerName;
    String productName;
    Integer price;
    Category category;
    Integer quantity;
    ProductStatus productStatus;
}
