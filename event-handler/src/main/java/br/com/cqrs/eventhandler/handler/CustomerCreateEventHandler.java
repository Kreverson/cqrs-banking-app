package br.com.cqrs.eventhandler.handler;

import br.com.cqrs.common.domain.model.Customer;
import br.com.cqrs.common.events.CustomerCreateEvent;
import br.com.cqrs.eventhandler.service.customer.CustomerService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component("CUSTOMER_CREATE")
@RequiredArgsConstructor
public class CustomerCreateEventHandler implements EventHandler {

    private final CustomerService clientService;
    private final Gson gson;

    @Override
    public void handle(
            final JsonObject object,
            final Acknowledgment acknowledgment
    ) {
        CustomerCreateEvent event = gson.fromJson(
                object,
                CustomerCreateEvent.class
        );
        Customer customer = gson.fromJson(
                (String) event.getPayload(),
                Customer.class
        );
        clientService.create(customer);
        acknowledgment.acknowledge();
    }
}
