package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.response.ProductDetailResponse;
import com.example.demo.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = """
             SELECT p.id, p.name, avatar.url  FROM product p
             JOIN  (SELECT MAX(i.url) AS url, i.id_product FROM img i GROUP BY i.id_product) AS avatar  ON  avatar.id_product = p.id
            """, nativeQuery = true)
    List<ProductResponse> getAllProduct();
}
