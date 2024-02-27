package com.example.demo.util.model.aliexpress.property;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValue {

    @SerializedName("skuColorValue")
    private String skuColorValue;

    @SerializedName("skuPropertyTips")
    private String skuPropertyTips;

    @SerializedName("propertyValueName")
    private String propertyValueName;

    @SerializedName("propertyValueId")
    private Long propertyValueId;

    @SerializedName("skuPropertyImagePath")
    private String skuPropertyImagePath;

    @SerializedName("skuPropertyValueTips")
    private String skuPropertyValueTips;

    @SerializedName("propertyValueDefinitionName")
    private String propertyValueDefinitionName;

    @SerializedName("propertyValueIdLong")
    private Long propertyValueIdLong;

    @SerializedName("propertyValueDisplayName")
    private String propertyValueDisplayName;

    @SerializedName("skuPropertyValueShowOrder")
    private Long skuPropertyValueShowOrder;

}
