package co.uk.credit.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.uk.credit.card.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
