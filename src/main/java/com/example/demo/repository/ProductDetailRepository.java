package com.example.demo.repository;

import com.example.demo.entity.ProductDetail;
import com.example.demo.response.ProductDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, String> {

    @Query(value = """
             SELECT
                 pd.id,
                 pd.price,
                 pd.quantity,
                 CONCAT('[', GROUP_CONCAT(
                     CONCAT('{"attributes_group":', a.id, ',"attributes_id":"', av.id, ',"attributes_name":"', av.value, '"}')
                 ), ']') AS children
             FROM
                 product_detail pd
             LEFT JOIN
                 product p ON p.id = pd.id_product
             LEFT JOIN
                 attributes_product ap ON ap.id_product = pd.id
             LEFT JOIN
                 attributes_values av ON av.id = ap.id_attribute_value
            LEFT JOIN attributes a ON a.id = av.id_attribute
             WHERE
                 pd.id_product = :id
             GROUP BY pd.id
            """, nativeQuery = true)
    List<ProductDetailResponse> getAllProductDetailByIdProduct(@Param("id") String id);
}
