package com.lucas.culture.adapter.in.controllers.v1.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@Getter
@Setter
public class MovieRequest{

    @NotBlank
    private final String title;

    @NotBlank @JsonProperty("release_date")
    private final String releaseDate;

    @NotNull @Positive
    private final Double price;

    @NotNull @Positive
    private final Integer stock;

}
