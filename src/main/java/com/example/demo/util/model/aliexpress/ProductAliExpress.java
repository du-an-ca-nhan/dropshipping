package com.example.demo.util.model.aliexpress;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductAliExpress {

    @SerializedName("imageComponent")
    private ImageComponent imageComponent;

    @SerializedName("metaDataComponent")
    private MetaDataComponent metaDataComponent;

    @SerializedName("productDescComponent")
    private ProductDescComponent productDescComponent;

    @SerializedName("priceComponent")
    private PriceComponent priceComponent;


    @SerializedName("skuComponent")
    private SkuComponent skuComponent;


    public ImageComponent getImageComponent() {
        return imageComponent;
    }

    public MetaDataComponent getMetaDataComponent() {
        return metaDataComponent;
    }

    public ProductDescComponent getProductDescComponent() {
        return productDescComponent;
    }

    public PriceComponent getPriceComponent() {
        return priceComponent;
    }

    public SkuComponent getSkuComponent() {
        return skuComponent;
    }
}
