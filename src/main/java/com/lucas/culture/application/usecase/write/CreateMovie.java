package com.lucas.culture.application.usecase.write;

import com.lucas.culture.adapter.in.controllers.v1.response.MovieResponse;
import com.lucas.culture.application.domain.MovieEntity;

public interface CreateMovie {
    MovieResponse execute(MovieEntity movieEntity);
}
