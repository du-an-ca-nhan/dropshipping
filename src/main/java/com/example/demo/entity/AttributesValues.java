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
@Table(name = "attributes_values")
@AllArgsConstructor
@NoArgsConstructor
public class AttributesValues extends PrimaryEntity {

    private String value;

    private Long idAliExpress;

    private Long skuPropertyValueShowOrder;

    @ManyToOne
    @JoinColumn(name = "id_attribute")
    private Attributes attributes;
}
