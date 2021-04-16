package com.lucas.culture.adapter.in.kafka.consumer;


import com.lucas.culture.adapter.in.kafka.schema.UserAvroSchema;
import com.lucas.culture.application.domain.UserEntity;
import com.lucas.culture.application.usecase.write.CreateUser;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public record UserKafkaConsumer(CreateUser createUser, ModelMapper mapper) {

    @KafkaListener(topics = "TOPIC_NEW_USER", groupId = "new_users")
    public void createMovie(ConsumerRecord<String, UserAvroSchema> payload){
        UserAvroSchema value = payload.value();

        UserEntity userEntity = mapper.map(value, UserEntity.class);
        createUser.execute(userEntity);


        //TODO criar producer para enviar e-mail com a senha gerada automaticamento;
    }
}
