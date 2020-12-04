package com.example.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.credit.card.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
