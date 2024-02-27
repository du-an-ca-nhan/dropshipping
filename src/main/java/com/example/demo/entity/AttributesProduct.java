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
@Table(name = "attributes_product")
@AllArgsConstructor
@NoArgsConstructor
public class AttributesProduct extends PrimaryEntity {


    private String url;

    private String code;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductDetail productDetail;


    @ManyToOne
    @JoinColumn(name = "id_attribute_value")
    private AttributesValues attributesValues;
}