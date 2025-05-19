package br.com.cqrs.common.service;

import java.util.UUID;

public interface QueryService<T> {

    T getById(UUID id);
}
