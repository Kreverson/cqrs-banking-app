package br.com.cqrs.banking.app.repository;

import br.com.cqrs.banking.app.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    boolean existsByNumberAndDate(String number, String date);
}
