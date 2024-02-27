package com.example.demo.util.model.aliexpress;

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
public class PriceComponent {

    @SerializedName("skuBulkDiscount")
    private int skuBulkDiscount;

    @SerializedName("skuJson")
    private String skuJson;

    @SerializedName("vatDesc")
    private String vatDesc;

    @SerializedName("displayBulkInfo")
    private boolean displayBulkInfo;

    @SerializedName("skuPriceList")
    private List<ProductDetailAliExpress> productDetailAliExpresses;
}
