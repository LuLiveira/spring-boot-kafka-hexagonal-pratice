package com.lucas.culture.application.usecase.write.impl;

import com.lucas.culture.adapter.in.kafka.schema.UserAvroSchema;
import com.lucas.culture.adapter.out.PeopleRepository;
import com.lucas.culture.application.domain.PeopleEntity;
import com.lucas.culture.application.usecase.write.CreatePeople;
import com.lucas.culture.application.usecase.write.KafkaProducer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public record CreatePeopleImpl(PeopleRepository repository, KafkaProducer<UserAvroSchema> producer, ModelMapper mapper) implements CreatePeople {

    @Override
    public void execute(PeopleEntity entity) {
        var people = repository.save(entity);

        UserAvroSchema schema = mapper.map(entity, UserAvroSchema.class);
        producer.execute(schema);

    }
}
