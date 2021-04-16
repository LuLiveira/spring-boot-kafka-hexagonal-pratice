package com.lucas.culture.application.usecase.write;

public interface KafkaProducer<T> {
    void execute(T obj);
}
