package br.com.cqrs.banking.app.service;

public interface CommandService<T> {

    void create(T object);
}
