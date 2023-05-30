package com.project.FlipCommerce.Model;

import com.project.FlipCommerce.Enum.Category;
import com.project.FlipCommerce.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Integer price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    Category category;

    @Column(name = "quantity")
    Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_status")
    ProductStatus productStatus;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    Seller seller;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();



}
