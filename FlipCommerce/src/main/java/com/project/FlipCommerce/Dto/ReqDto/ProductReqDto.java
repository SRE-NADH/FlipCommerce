package com.project.FlipCommerce.Dto.ReqDto;

import com.project.FlipCommerce.Enum.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductReqDto {
    String name;
    Integer price;
    Category category;
    Integer quantity;
    String email;

}
