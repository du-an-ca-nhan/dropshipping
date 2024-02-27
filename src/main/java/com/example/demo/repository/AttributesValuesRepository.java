package com.example.demo.repository;

import com.example.demo.entity.AttributesValues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributesValuesRepository extends JpaRepository<AttributesValues, String> {

    Optional<AttributesValues> findByValue(String name);

    Optional<AttributesValues> findByIdAliExpress(Long id);
}
