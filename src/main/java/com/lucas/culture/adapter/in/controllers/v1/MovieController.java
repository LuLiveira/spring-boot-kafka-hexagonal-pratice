package com.lucas.culture.adapter.in.controllers.v1;

import com.lucas.culture.adapter.in.controllers.v1.request.MovieRequest;
import com.lucas.culture.adapter.in.controllers.v1.response.MovieResponse;
import com.lucas.culture.application.domain.MovieEntity;
import com.lucas.culture.application.usecase.write.CreateMovie;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/movies")
public record MovieController (CreateMovie createMovie, ModelMapper mapper) {

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody @Valid MovieRequest request){
        MovieEntity movieEntity = mapper.map(request, MovieEntity.class);
        return ResponseEntity.ok(createMovie.execute(movieEntity));
    }

}
