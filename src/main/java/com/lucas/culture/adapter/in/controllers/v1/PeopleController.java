package com.lucas.culture.adapter.in.controllers.v1;

import com.lucas.culture.adapter.in.controllers.v1.request.PeopleRequest;
import com.lucas.culture.application.domain.PeopleEntity;
import com.lucas.culture.application.usecase.write.CreatePeople;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/peoples")
public record PeopleController(CreatePeople createPeople, ModelMapper mapper) {

    public void createPeople(@RequestBody @Valid PeopleRequest request) {
        PeopleEntity people = mapper.map(request, PeopleEntity.class);
        createPeople.execute(people);
    }
}
