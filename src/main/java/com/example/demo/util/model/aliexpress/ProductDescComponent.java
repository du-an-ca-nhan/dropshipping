package com.example.demo.util.model.aliexpress;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDescComponent {

    @SerializedName("descriptionUrl")
    private String descriptionUrl;
}
