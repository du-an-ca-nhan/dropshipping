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
public class SkuVal {

    @SerializedName("optionalWarrantyPrice")
    private Object optionalWarrantyPrice;

    @SerializedName("skuAmount")
    private SkuAmount skuAmount;

    @SerializedName("skuExtraTips")
    private String skuExtraTips;

    @SerializedName("discount")
    private String discount;

    @SerializedName("availQuantity")
    private Long availQuantity;

    @SerializedName("inventory")
    private int inventory;

    @SerializedName("hideOriPrice")
    private boolean hideOriPrice;

    @SerializedName("skuCalPrice")
    private String skuCalPrice;

    @SerializedName("skuAmountLocal")
    private String skuAmountLocal;

    @SerializedName("skuActivityAmountLocal")
    private String skuActivityAmountLocal;

    @SerializedName("discountTips")
    private String discountTips;

    @SerializedName("isActivity")
    private boolean isActivity;

    @SerializedName("bulkOrder")
    private int bulkOrder;

    @SerializedName("skuActivityAmount")
    private SkuAmount skuActivityAmount;

}
