package com.lucas.culture.adapter.in.controllers.v1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private String title;
    private String releaseDate;
    private  BigDecimal price;
    private Integer  stock;
}
