package br.com.cqrs.banking.app.service;

import java.util.UUID;

public interface QueryService<T> {

    T getById(UUID id);
}
