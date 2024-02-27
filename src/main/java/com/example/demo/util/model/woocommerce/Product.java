package com.example.demo.util.model.woocommerce;

import com.example.demo.util.model.aliexpress.ProductAliExpress;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    public Product(ProductAliExpress productAliExpress) {
        this.name = productAliExpress.getMetaDataComponent().getTitle();
        this.type = "variable";
        this.description = "description";
        this.short_description = "short_description";
        this.categories = new ArrayList<>();
        this.images = productAliExpress.getImageComponent().convertStringListToImageList();
        this.attributes = productAliExpress.getSkuComponent().convertStringListToAttribute();
    }

    private String name;

    private String type ;

    private String description;

    private String short_description;

    private List<Categorie> categories;

    private List<Image> images;

    private List<Attribute> attributes;

}
