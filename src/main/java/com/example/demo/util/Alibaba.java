package com.example.demo.util;

import com.example.demo.service.aliexpress.AliExpressService;
import com.example.demo.util.model.aliexpress.ProductAliExpress;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Alibaba {

    public static List<ProductAliExpress> getAllByNameAndPage(String name, int page) {
        String modifiedString = name.replace(" ", "+");
        String url = "https://www.alibaba.com/trade/search?keywords="+modifiedString+"&tab=all&page="+ page;
        try {
            Document document = Jsoup.connect(url).get();

            Element scriptElement = document.body();

            // Kiểm tra xem có phần tử script không
            if (scriptElement != null) {
                String scriptContent = scriptElement.html();
                String regex = "href=\"//www\\.alibaba\\.com/product-detail/(.*?)\"";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(scriptContent);
                List<ProductAliExpress> list = new ArrayList<>();
                while (matcher.find()) {
                    String productValue = matcher.group(1);
                    System.out.println(getProduct(productValue));
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
    public static JsonObject getProduct(String id){
        String url = "https://www.alibaba.com/product-detail/"+id+"";

        try {
            Document document = Jsoup.connect(url).get();
            Element scriptElement = document.select("script:containsData(window.detailData)").first();
            if (scriptElement != null) {
                String scriptContent = scriptElement.html();
                String regex = "window\\.__version__map=\\{\\s*'magicEditLoaderVersion':'(.*?)','icbuPcDetailAll':'(.*?)'}";
                String jsonValue = scriptContent.replaceAll("\\s", "").replaceAll(regex, "$1");
                String jsonValue2 = jsonValue.substring(jsonValue.indexOf("{"), jsonValue.lastIndexOf("}") + 1);
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(  jsonValue2 , JsonObject.class);
                return jsonObject;
            } else {
                System.out.println("Không tìm thấy phần tử script chứa window.detailData");
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        getAllByNameAndPage("shose",1);
    }
}
