package br.com.cqrs.core.service;

public interface CommandService<T> {

    void create(T object);
}
