package com.example.demo.entity;

import com.example.demo.entity.base.PrimaryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "attributes")
@AllArgsConstructor
@NoArgsConstructor
public class Attributes extends PrimaryEntity {

    private String name;

    private Long propertyId;

}
