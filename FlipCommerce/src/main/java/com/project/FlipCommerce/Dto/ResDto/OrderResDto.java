package com.project.FlipCommerce.Dto.ResDto;

import com.project.FlipCommerce.Model.Item;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderResDto {
    String customerName;

    String orderNo;

    int totalValue;

    Date orderDate;

    String cardUsed;

    List<ItemResDto> itemList;
}
