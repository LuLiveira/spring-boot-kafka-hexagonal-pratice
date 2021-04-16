package com.lucas;

import com.lucas.culture.adapter.in.kafka.schema.UserAvroSchema;
import org.apache.kafka.clients.admin.NewTopic;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class CultureApplication {

	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("MOVIE").build();
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();

		var fromStringToDate = new AbstractConverter<String, LocalDate>() {
			@Override
			protected LocalDate convert(String s) {
				return LocalDate.parse(s);
			}
		};

		modelMapper.createTypeMap(String.class, LocalDate.class);
		modelMapper.addConverter(fromStringToDate);

		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(CultureApplication.class, args);
	}

}
