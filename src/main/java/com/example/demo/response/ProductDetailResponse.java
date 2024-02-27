package com.example.demo.response;

import com.example.demo.entity.Attributes;
import com.example.demo.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * @author thangdt
 */

@Projection(types = {ProductDetail.class, Attributes.class})
public interface ProductDetailResponse {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.price}")
    BigDecimal getPrice();

    @Value("#{target.quantity}")
    int getQuantity();

    @Value("#{target.children}")
    String getAttribute();

}
