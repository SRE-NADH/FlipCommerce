package com.project.FlipCommerce.Dto.ResDto;

import com.project.FlipCommerce.Enum.CardType;
import com.project.FlipCommerce.Transformer.CardTransformer;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResDto {
    String cardNo;

    CardType cardType;

    String name;
}
