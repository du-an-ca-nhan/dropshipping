package com.example.demo.response;

import com.example.demo.entity.Attributes;
import com.example.demo.entity.Img;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Product.class, Img.class})
public interface ProductResponse {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.name}")
    String getName();

    @Value("#{target.url}")
    String getUrl();
}
