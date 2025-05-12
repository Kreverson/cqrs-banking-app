package br.com.cqrs.banking.app.repository;

import br.com.cqrs.banking.app.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
