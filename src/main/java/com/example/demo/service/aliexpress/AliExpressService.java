package com.example.demo.service.aliexpress;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.util.model.aliexpress.ImageComponent;
import com.example.demo.util.model.aliexpress.PriceComponent;
import com.example.demo.util.model.aliexpress.ProductAliExpress;
import com.example.demo.util.model.aliexpress.SkuComponent;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class AliExpressService {

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

    public void createproduct(ProductAliExpress productAliExpress){
        Product product = productRepository.save(Product.builder().name(productAliExpress.getMetaDataComponent().getTitle()).desc(productAliExpress.getProductDescComponent().getDescriptionUrl()).build());
        saveAllImg(product, productAliExpress.getImageComponent());
        saveAllAttributes(productAliExpress.getSkuComponent());
        saveAllAttributeValue(productAliExpress.getSkuComponent());
        saveAllProductDetail(product, productAliExpress.getPriceComponent());
    }
    private void saveAllAttributes(SkuComponent skuComponent){
        skuComponent.getProductSKUPropertyList().stream().forEach(item ->{
            Optional<Attributes> attributes = attributesRepository.findByPropertyId(item.getSkuPropertyId());
            if(!attributes.isPresent()){
                attributesRepository.save(Attributes.builder().name(item.getSkuPropertyName()).propertyId(item.getSkuPropertyId()).build());
            }
        });
    }

    private void saveAllProductDetail(Product product, PriceComponent priceComponent){
        priceComponent.getProductDetailAliExpresses().stream().forEach(item ->{
            if(item.getSkuVal().getAvailQuantity() > 100){
                List<String> value = List.of(item.getSkuPropIds().split(","));
                ProductDetail productDetail = productDetailRepository.save(ProductDetail.builder().product(product).quantity(item.getSkuVal().getAvailQuantity()).price(new BigDecimal(item.getSkuVal().getSkuAmount().getValue())).build());
                value.stream().forEach(id ->{
                    Optional<AttributesValues> attributesValues = attributesValuesRepository.findByIdAliExpress(Long.valueOf(id));
                    if(attributesValues.isPresent()){
                        attributesProductRepository.save(AttributesProduct.builder().productDetail(productDetail).attributesValues(attributesValues.get()).build());
                    }
                });
            }

        });
    }

    private void saveAllAttributeValue(SkuComponent skuComponent){
        skuComponent.getProductSKUPropertyList().stream().forEach(item ->{
            Optional<Attributes> attributes = attributesRepository.findByPropertyId(item.getSkuPropertyId());
            item.getPropertyValues().stream().forEach(value ->{
                Optional<AttributesValues> attributesValues = attributesValuesRepository.findByIdAliExpress(value.getPropertyValueId());
                if(!attributesValues.isPresent()){
                    attributesValuesRepository.save(AttributesValues.builder().attributes(attributes.get()).idAliExpress(value.getPropertyValueId()).skuPropertyValueShowOrder(value.getSkuPropertyValueShowOrder()).value(value.getPropertyValueName()).build());
                }
            });
        });
    }
    private void saveAllImg(Product product, ImageComponent imageComponent){
//        imageComponent.getImage250PathList().stream().forEach(item ->{
//            imgRepository.save(Img.builder().url(item).product(product).build());
//        });
        imageComponent.getImagePathList().stream().forEach(item ->{
            imgRepository.save(Img.builder().url(item).product(product).build());
        });
//        imageComponent.getImage640PathList().stream().forEach(item ->{
//            imgRepository.save(Img.builder().url(item).product(product).build());
//        });
//        imageComponent.getSummImagePathList().stream().forEach(item ->{
//            imgRepository.save(Img.builder().url(item).product(product).build());
//        });
    }
}
