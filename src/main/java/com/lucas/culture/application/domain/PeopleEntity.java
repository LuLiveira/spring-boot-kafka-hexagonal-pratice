package com.lucas.culture.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeopleEntity {

    @Id
    private UUID uuid;

    @Column(name = "name", nullable = false, updatable = false, length = 200)
    private String name;

    @Column(name = "email", nullable = false, length = 200, unique = true)
    private String email;
}
