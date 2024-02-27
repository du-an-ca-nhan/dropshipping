package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.response.ProductDetailResponse;
import com.example.demo.response.ProductResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    void createAllProductFormAliExpress(String name);

    List<ProductDetailResponse> getAllProductDetailByIdProduct(@Param("id") String id);

    List<ProductResponse> getAllProduct();

    Product findById(String id);
}
