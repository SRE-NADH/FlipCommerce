package com.project.FlipCommerce.Repocitory;

import com.project.FlipCommerce.Enum.Category;
import com.project.FlipCommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepocitory extends JpaRepository<Product,Integer> {

    List<Product> findByCategoryAndPrice(Category category, int price);
}
