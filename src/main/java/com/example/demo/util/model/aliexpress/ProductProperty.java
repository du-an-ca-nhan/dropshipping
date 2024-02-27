package com.example.demo.util.model.aliexpress;

import com.example.demo.util.model.aliexpress.property.PropertyValue;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductProperty {

    @SerializedName("showTypeColor")
    private boolean showTypeColor;

    @SerializedName("sizeProperty")
    private boolean sizeProperty;

    @SerializedName("showType")
    private String showType;

    @SerializedName("skuPropertyName")
    private String skuPropertyName;

    @SerializedName("skuPropertyId")
    private Long skuPropertyId;

    @SerializedName("order")
    private Long order;

    @SerializedName("skuPropertyValues")
    private List<PropertyValue> propertyValues;
}
