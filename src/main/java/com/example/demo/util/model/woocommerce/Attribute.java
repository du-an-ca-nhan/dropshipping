package com.example.demo.util.model.woocommerce;

import com.example.demo.util.model.aliexpress.ProductProperty;
import com.example.demo.util.model.aliexpress.property.PropertyValue;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attribute {

    private String name;

    private int position;

    private boolean visible;

    private boolean variation;

    private List<String> options;


    public Attribute(ProductProperty productProperty) {
        this.name = productProperty.getSkuPropertyName();
        this.position = 0;
        this.visible = true;
        this.variation = true;
        this.options = productProperty.getPropertyValues().stream()
                .map(PropertyValue::getPropertyValueName)
                .collect(Collectors.toList());
    }
}
