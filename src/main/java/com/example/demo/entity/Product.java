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
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends PrimaryEntity {

    private String code;

    private String name;

    private String desc;

}
