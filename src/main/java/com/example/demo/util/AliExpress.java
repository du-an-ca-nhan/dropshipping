package com.example.demo.util;

import com.example.demo.service.aliexpress.AliExpressService;
import com.example.demo.service.woocommerce.WoocommerceService;
import com.example.demo.util.model.aliexpress.ProductAliExpress;
import com.example.demo.util.model.aliexpress.ProductDetailAliExpress;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Component
public class AliExpress {

    public List<ProductAliExpress> getAllByNameAndPage(String name, int page, AliExpressService aliExpressService, WoocommerceService woocommerceService) {
        String modifiedString = name.replace(" ", "-");
        String url = "https://www.aliexpress.us/w/wholesale-" + modifiedString + ".html?page=" + page + "&g=y&SearchText=%C3%A1o+s%C6%A1+mi+tay+d%C3%A0i+ph%C3%A1p";
        try {
            Document document = Jsoup.connect(url).get();

            Element scriptElement = document.select("script:containsData(window._dida_config_._init_data_)").first();

            // Kiểm tra xem có phần tử script không
            if (scriptElement != null) {
                // Lấy nội dung của script
                String scriptContent = scriptElement.html();

                // Sử dụng regex để trích xuất giá trị của window._dida_config_._init_data_
                String regex = "window\\._dida_config_\\._init_data_\\s*=\\s*(\\[.*?\\]);";
                String initDataValue = scriptContent.replaceAll("\\s", "").replaceAll(regex, "$1");
                String regex1 = "\"productId\":\\s*\"(.*?)\"";
                Pattern pattern = Pattern.compile(regex1);
                Matcher matcher = pattern.matcher(initDataValue);
                List<ProductAliExpress> list = new ArrayList<>();
                while (matcher.find()) {
                    String productValue = matcher.group(1);
                    JsonObject product = getProduct(productValue);
                    if (checkQuantity(product)) {
                        try {
                            aliExpressService.createproduct(getProductDetail(product));
                            woocommerceService.saveProduct(getProductDetail(product));
                        } catch (Exception e) {
                            System.out.println("Có lỗi xảy ra khi lưu trữ sản phẩm: " + e.getMessage());
                        }
                    }
                }
                return list;
            } else {
                System.out.println("Không tìm thấy phần tử script chứa window._dida_config_._init_data_");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ProductAliExpress getProductDetail(JsonObject jsonObject) {
        return new Gson().fromJson(jsonObject, ProductAliExpress.class);
    }

    public boolean checkQuantity(JsonObject jsonObject) {
        JsonObject skuComponent = jsonObject.getAsJsonObject("priceComponent");
        JsonArray skuPriceList = skuComponent.getAsJsonArray("skuPriceList");
        return StreamSupport.stream(skuPriceList.spliterator(), false)
                .map(JsonElement::getAsJsonObject)
                .map(skuPriceListItem -> skuPriceListItem.getAsJsonObject("skuVal"))
                .anyMatch(productDetail -> {
                    String availQuantity = productDetail.get("availQuantity").getAsString();
                    return Integer.parseInt(availQuantity) > 100;
                });
    }

    public JsonObject getProduct(String id) {
        String url = "https://vi.aliexpress.com/item/" + id + ".html";

        try {
            Document document = Jsoup.connect(url).get();
            Element scriptElement = document.select("script:containsData(window.runParams)").first();
            if (scriptElement != null) {
                String scriptContent = scriptElement.html();
                String regex = "window\\.runParams\\s*=\\s*\\{(.*?)};";
                String runParamsValue = scriptContent.replaceAll("\\s", "").replaceAll(regex, "$1");
                String jsonValue = runParamsValue.substring(runParamsValue.indexOf("{"), runParamsValue.lastIndexOf("}") + 1);
                JsonObject jsonObject = new Gson().fromJson(jsonValue, JsonObject.class);
                return jsonObject;
            } else {
                System.out.println("Không tìm thấy phần tử script chứa window.runParams");
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
