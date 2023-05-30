package com.project.FlipCommerce.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "item")
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "required_quantity")
    int requiredQuantity;

    @ManyToOne
    @JoinColumn(name= "product_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;
}
