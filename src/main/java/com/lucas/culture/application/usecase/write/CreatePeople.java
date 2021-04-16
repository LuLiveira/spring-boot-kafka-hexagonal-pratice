package com.lucas.culture.application.usecase.write;

import com.lucas.culture.application.domain.PeopleEntity;
import org.springframework.stereotype.Service;

public interface CreatePeople {

    void execute(PeopleEntity entity);
}
