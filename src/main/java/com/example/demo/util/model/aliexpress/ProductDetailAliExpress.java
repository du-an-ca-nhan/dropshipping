package com.example.demo.util.model.aliexpress;

import com.example.demo.util.model.aliexpress.property.SkuVal;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailAliExpress {
    @SerializedName("skuVal")
    private SkuVal skuVal;

    @SerializedName("skuPropIds")
    private String skuPropIds;

    @SerializedName("skuIdStr")
    private String skuIdStr;

}
