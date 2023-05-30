package com.project.FlipCommerce.Repocitory;

import com.project.FlipCommerce.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepocitory extends JpaRepository<Seller,Integer> {

    Seller findByEmail(String email);
}
