package com.example.demo.util.model.aliexpress;

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
public class ImageComponent {

    @SerializedName("image250PathList")
    private List<String> image250PathList;

    @SerializedName("imagePathList")
    private List<String> imagePathList;

    @SerializedName("image640PathList")
    private List<String> image640PathList;

    @SerializedName("summImagePathList")
    private List<String> summImagePathList;


    public List<Image> convertStringListToImageList() {
        return this.imagePathList.stream()
                .map(src -> new Image(src)) // Chú ý rằng id được đặt là null trong ví dụ này
                .collect(Collectors.toList());
    }
}
