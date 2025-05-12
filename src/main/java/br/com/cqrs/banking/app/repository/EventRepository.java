package br.com.cqrs.banking.app.repository;

import br.com.cqrs.banking.app.events.AbstractEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}
