package com.lucas.culture.adapter.in.kafka.config;

import com.lucas.culture.adapter.in.kafka.schema.UserAvroSchema;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@EnableKafka
@Configuration
class KafkaProducerConfig {

    @Value("${consumer.kafka.bootstrap-servers-config}")
    private String bootstrapServersConfig;

    @Value("${consumer.key-serializer}")
    private String consumerKeyDeserializer;

    @Value("${consumer.value-serializer}")
    private String consumerValueDeserializer;

    @Value("${schema-registry-url}")
    private String schemaRegistryUrl;



    @Bean
    public Map<String, Object> producerProperties() {
        return Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServersConfig,
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, consumerKeyDeserializer,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, consumerValueDeserializer,
                AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "http://127.0.0.1:9092");
//
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class.getName());
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                KafkaAvroSerializer.class.getName());
//        props.put(KafkaAvroDeserializerConfig., "http://127.0.0.1:8081");
    }

    @Bean
    public ProducerFactory<String, UserAvroSchema> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerProperties());
    }

    @Bean
    public KafkaTemplate<String, UserAvroSchema> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
//
//    @Bean
//    public DefaultKafkaConsumerFactory<String, MovieProducerSchema> producerConfigs2() {
//        Map<String,Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://127.0.0.1:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "movie");
//
//
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroDeserializer");
//        props.put("schema.registry.url", "http://127.0.0.1:8081");
//        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
//
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//        return new DefaultKafkaConsumerFactory<>(props);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, MovieProducerSchema>
//    kafkaListenerContainerFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<String, MovieProducerSchema> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(producerConfigs2());
//        return factory;
//    }


}
