package com.project.FlipCommerce.Model;

import com.project.FlipCommerce.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "order_entity")
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "order_no")
    String orderNo;

    @Column(name = "total_value")
    int totalValue;

    @CreationTimestamp
    @Column(name="order_date")
    Date orderDate;

    String cardUsed;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();

    @ManyToOne
    Customer customer;

}
