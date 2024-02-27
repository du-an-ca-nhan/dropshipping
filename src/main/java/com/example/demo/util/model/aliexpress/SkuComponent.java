package com.example.demo.util.model.aliexpress;

import com.example.demo.util.model.woocommerce.Attribute;
import com.example.demo.util.model.woocommerce.Image;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkuComponent {

    @SerializedName("selectedSkuAttr")
    private String selectedSkuAttr;


    @SerializedName("hasSkuProperty")
    private boolean hasSkuProperty;

    @SerializedName("skuPropertyJson")
    private String skuPropertyJson;

    @SerializedName("productSKUPropertyList")
    private List<ProductProperty> productSKUPropertyList;

    public List<Attribute> convertStringListToAttribute() {
        return this.productSKUPropertyList.stream()
                .map(productProperty -> new Attribute(productProperty)) // Chú ý rằng id được đặt là null trong ví dụ này
                .collect(Collectors.toList());
    }

}
