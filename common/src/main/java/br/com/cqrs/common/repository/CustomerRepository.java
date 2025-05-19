package br.com.cqrs.common.repository;

import br.com.cqrs.common.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findByUsername(String username);

    boolean existsByUsername(String username);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = """
            INSERT INTO customers_cards
            VALUES (:customerId, :cardId)
            """, nativeQuery = true
    )
    void addCard(
            @Param("customerId") String customerId,
            @Param("cardId") String cardId
    );
}
