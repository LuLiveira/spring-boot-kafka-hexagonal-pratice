package com.lucas.culture.application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name= "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieEntity {

    @Id
    private UUID uuid;

    @Column(unique = true, length = 200, nullable = false )
    private String title;

    @Column(name = "release_date", nullable = false, unique = false)
    @JsonProperty("release_date")
    private LocalDate releaseDate;

    private BigDecimal price;
    private Integer stock;

    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(name = "updatedAt", nullable = false)
    private LocalDate updatedAt = LocalDate.now();

    @Override
    public String toString() {
        return "MovieEntity{" +
                " name='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
