package com.lucas.culture.application.usecase.write;

import com.lucas.culture.adapter.in.controllers.v1.response.MovieResponse;
import com.lucas.culture.application.domain.MovieEntity;
import com.lucas.culture.application.domain.UserEntity;

public interface CreateUser {
    void execute(UserEntity userEntity);
}
