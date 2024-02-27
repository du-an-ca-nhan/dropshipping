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
public class MetaDataComponent {

    @SerializedName("keywords")
    private String keywords;

    @SerializedName("canonicalTag")
    private String canonicalTag;

    @SerializedName("hreflangTag")
    private String hreflangTag;

    @SerializedName("ogTitle")
    private String ogTitle;

    @SerializedName("description")
    private String description;

    @SerializedName("mediaTag")
    private String mediaTag;

    @SerializedName("ogurl")
    private String ogurl;

    @SerializedName("amphtmlTag")
    private String amphtmlTag;

    @SerializedName("ogDescription")
    private String ogDescription;

    @SerializedName("title")
    private String title;
}
