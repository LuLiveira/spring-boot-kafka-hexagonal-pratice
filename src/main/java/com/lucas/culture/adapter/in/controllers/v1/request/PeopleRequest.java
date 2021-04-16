package com.lucas.culture.adapter.in.controllers.v1.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeopleRequest {

    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;

}
