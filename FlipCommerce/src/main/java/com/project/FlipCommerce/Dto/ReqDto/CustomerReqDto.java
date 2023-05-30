package com.project.FlipCommerce.Dto.ReqDto;

import com.project.FlipCommerce.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerReqDto {
    String name;
    String email;
    String mobNo;
    Gender gender;
}
