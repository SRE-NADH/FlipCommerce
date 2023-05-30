package com.project.FlipCommerce.Repocitory;

import com.project.FlipCommerce.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepocitory extends JpaRepository<Customer,Integer> {

    Customer findByEmail(String email);
}
