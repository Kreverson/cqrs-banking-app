package br.com.cqrs.common.repository;

import br.com.cqrs.common.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    boolean existsByNumberAndDate(String number, String date);
    Optional<Card> existsByNumberAndDateAndCvv(String number, String date, String cvv);
}
