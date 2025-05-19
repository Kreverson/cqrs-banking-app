package br.com.cqrs.eventhandler.handler;

import com.google.gson.JsonObject;
import org.springframework.kafka.support.Acknowledgment;

public interface EventHandler {

    void handle(
            JsonObject object,
            Acknowledgment acknowledgment
    );
}
