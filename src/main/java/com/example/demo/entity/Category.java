package com.example.demo.entity;

import com.example.demo.entity.base.PrimaryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
public class Category extends PrimaryEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_parent")
    private Category category;
}
