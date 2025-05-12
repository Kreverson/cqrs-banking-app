package br.com.cqrs.banking.app.repository;

import br.com.cqrs.banking.app.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}