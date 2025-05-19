package br.com.cqrs.eventhandler.service;

import org.springframework.kafka.support.Acknowledgment;

public interface CDCEventConsumer {

    void process(
            String payload,
            Acknowledgment acknowledgment
    );

}
