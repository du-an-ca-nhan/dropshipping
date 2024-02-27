package com.example.demo.entity;

import com.example.demo.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "img")
@AllArgsConstructor
@NoArgsConstructor
public class Img extends PrimaryEntity {

    @Column(length = 65535)
    private String url;


    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;
}
