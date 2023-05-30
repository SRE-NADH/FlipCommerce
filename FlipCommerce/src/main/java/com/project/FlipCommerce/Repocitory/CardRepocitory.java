package com.project.FlipCommerce.Repocitory;

import com.project.FlipCommerce.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepocitory extends JpaRepository<Card,Integer> {
    Card findByCardNo(String cardNo);
}
