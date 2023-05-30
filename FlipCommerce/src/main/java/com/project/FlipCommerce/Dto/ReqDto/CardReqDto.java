package com.project.FlipCommerce.Dto.ReqDto;

import com.project.FlipCommerce.Enum.CardType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.logging.Level;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CardReqDto {

    String cardNo;

    int cvv;

    CardType cardType;

    Date validTill;

    String email;
}
