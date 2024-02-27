package com.example.demo.entity;

import com.example.demo.entity.base.PrimaryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Builder
@Table(name = "product_detail")
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail extends PrimaryEntity {

    private BigDecimal price;

    private Long quantity;

    private String content;

    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;

}
