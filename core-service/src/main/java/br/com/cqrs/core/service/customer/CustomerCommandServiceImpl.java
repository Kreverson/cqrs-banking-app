package br.com.cqrs.core.service.customer;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.common.events.CustomerCreateEvent;
import br.com.cqrs.core.service.event.EventService;
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
