package br.com.cqrs.common.events;

import br.com.cqrs.common.domain.aggregate.Aggregate;
import br.com.cqrs.common.domain.model.Customer;
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
