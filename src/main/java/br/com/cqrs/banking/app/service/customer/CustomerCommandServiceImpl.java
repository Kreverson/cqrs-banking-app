package br.com.cqrs.banking.app.service.customer;

import br.com.cqrs.banking.app.domain.model.Customer;
import br.com.cqrs.banking.app.events.CustomerCreateEvent;
import br.com.cqrs.banking.app.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCommandServiceImpl implements CustomerCommandService {

    private final EventService eventService;

    @Override
    public void create(Customer object) {
        CustomerCreateEvent event = new CustomerCreateEvent(object);
        eventService.create(event);
    }
}
