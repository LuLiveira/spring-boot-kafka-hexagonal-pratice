package com.lucas.culture.application.usecase.write.impl;

import com.lucas.culture.adapter.in.kafka.schema.UserAvroSchema;
import com.lucas.culture.application.usecase.write.KafkaProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record UserKafkaProducerImpl(
        KafkaTemplate<String, UserAvroSchema> kafka) implements KafkaProducer<UserAvroSchema> {

    @Override
    public void execute(UserAvroSchema userAvroSchema) {
        userAvroSchema.setPassword(UUID.randomUUID().toString());
        kafka.send("TOPIC_NEW_USER", userAvroSchema.getPassword().toString(), userAvroSchema);
    }
}
