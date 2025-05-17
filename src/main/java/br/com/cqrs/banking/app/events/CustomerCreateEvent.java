package br.com.cqrs.banking.app.events;

import br.com.cqrs.banking.app.domain.aggregate.Aggregate;
import br.com.cqrs.banking.app.domain.model.Customer;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerCreateEvent extends AbstractEvent {

    public CustomerCreateEvent(Customer payload) {
        super(null, EventType.CUSTOMER_CREATE, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
