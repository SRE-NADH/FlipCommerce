package com.project.FlipCommerce.Repocitory;

import com.project.FlipCommerce.Model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepocitory extends JpaRepository<OrderEntity,Integer> {
}
