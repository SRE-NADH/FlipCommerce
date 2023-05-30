package com.project.FlipCommerce.Repocitory;

import com.project.FlipCommerce.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepocitory extends JpaRepository<Cart,Integer> {
}
