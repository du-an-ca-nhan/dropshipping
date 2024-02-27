package com.example.demo.controller;

import com.example.demo.request.ProductRequest;
import com.example.demo.response.ProductDetailResponse;
import com.example.demo.response.ProductResponse;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public  void getAllProductDetail(ProductRequest request){
        productService.createAllProductFormAliExpress(request.getName());
    }

    @GetMapping("/{id}")
    public List<ProductDetailResponse> getAllProductDetailByIdProduct(@PathVariable String id){
        return  productService.getAllProductDetailByIdProduct(id);
    }

    @GetMapping("")
    public List<ProductResponse> getAllProduct(){
        return  productService.getAllProduct();
    }
}
