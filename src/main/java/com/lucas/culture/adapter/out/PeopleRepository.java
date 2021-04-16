package com.lucas.culture.adapter.out;

import com.lucas.culture.application.domain.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeopleRepository extends JpaRepository<PeopleEntity, UUID> {
}
