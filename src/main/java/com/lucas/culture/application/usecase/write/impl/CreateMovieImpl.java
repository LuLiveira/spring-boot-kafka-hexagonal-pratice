package com.lucas.culture.application.usecase.write.impl;

import com.lucas.culture.adapter.in.controllers.v1.response.MovieResponse;
import com.lucas.culture.adapter.out.MovieRepository;
import com.lucas.culture.application.domain.MovieEntity;
import com.lucas.culture.application.usecase.write.CreateMovie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public record CreateMovieImpl(MovieRepository repository, ModelMapper mapper) implements CreateMovie {

    @Override
    public MovieResponse execute(MovieEntity movieEntity) {
        movieEntity.setUuid(UUID.randomUUID());
        movieEntity.setCreatedAt(LocalDate.now());
        var entity = repository.save(movieEntity);
        var response = mapper.map(entity, MovieResponse.class);
        return response;
    }
}
