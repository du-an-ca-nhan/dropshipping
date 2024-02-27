package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.response.ProductDetailResponse;
import com.example.demo.response.ProductResponse;
import com.example.demo.service.ProductService;
import com.example.demo.service.aliexpress.AliExpressService;
import com.example.demo.service.woocommerce.WoocommerceService;
import com.example.demo.util.AliExpress;
import com.example.demo.util.model.aliexpress.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private AttributesProductRepository attributesProductRepository;

    @Autowired
    private AttributesRepository attributesRepository;

    @Autowired
    private AttributesValuesRepository attributesValuesRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImgRepository imgRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AliExpressService aliExpressService;

    @Autowired
    private WoocommerceService woocommerceService;

    @Override
    public void createAllProductFormAliExpress(String name) {
        AliExpress aliExpress = new AliExpress();

        List<ProductAliExpress> productAliExpresses = aliExpress.getAllByNameAndPage(name, 1, aliExpressService, woocommerceService);
//        productAliExpresses.stream().forEach(item -> {

//        });
    }

    @Override
    public List<ProductDetailResponse> getAllProductDetailByIdProduct(String id) {
        return productDetailRepository.getAllProductDetailByIdProduct(id);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public Product findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }


}
