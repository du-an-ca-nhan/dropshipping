package com.example.demo.util.model.aliexpress.property;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkuAmount {

    @SerializedName("currency")
    private String currency;

    @SerializedName("formatedAmount")
    private String formatedAmount;

    @SerializedName("value")
    private double value;

}
