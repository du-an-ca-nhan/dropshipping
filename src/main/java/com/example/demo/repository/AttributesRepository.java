package com.example.demo.repository;

import com.example.demo.entity.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributesRepository extends JpaRepository<Attributes, String> {

    Optional<Attributes> findByName(String name);

    Optional<Attributes> findByPropertyId(Long propertyId);
}
