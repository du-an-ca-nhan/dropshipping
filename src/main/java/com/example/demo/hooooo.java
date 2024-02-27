package com.example.demo;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hooooo {

    private static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
    private static void createAndWriteJson(String filePath) {
        try {
            // Tạo dữ liệu mẫu
            // Sử dụng Gson để chuyển đối tượng thành chuỗi JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonData = gson.toJson("{}");

            // Tạo file và ghi dữ liệu vào đó
            try (Writer writer = new FileWriter(filePath)) {
                writer.write(jsonData);
            }

            System.out.println("File created and data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void appendJsonToFile( JsonObject jsonObject) {
        String filePath = "C:\\Users\\admin\\Downloads\\11. LANDING PAGE\\file.json";

        // Nếu file không tồn tại, tạo mới và ghi dữ liệu mẫu vào đó
        if (!fileExists(filePath)) {
            createAndWriteJson(filePath);
        }
        try {
            // Create JsonWriter to write directly to the file
            try (JsonWriter jsonWriter = new JsonWriter(new FileWriter(filePath, true))) {
                jsonWriter.beginObject(); // Start writing a JSON object

                jsonWriter.endObject(); // End writing the JSON object
                jsonWriter.flush(); // Flush the writer to ensure data is written to the file
            }

            System.out.println("Data appended to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String url = "https://vi.aliexpress.com/w/wholesale-qu%E1%BA%A7n-.html?spm=a2g0o.detail.search.0";
        try {
            Document document = Jsoup.connect(url).get();
            System.out.println("----------------------------------------------------");

            // Sử dụng querySelector để lấy phần tử script chứa window._dida_config_._init_data_
            Element scriptElement = document.select("script:containsData(window._dida_config_._init_data_)").first();

            // Kiểm tra xem có phần tử script không
            if (scriptElement != null) {
                // Lấy nội dung của script
                String scriptContent = scriptElement.html();

                // Sử dụng regex để trích xuất giá trị của window._dida_config_._init_data_
                String regex = "window\\._dida_config_\\._init_data_\\s*=\\s*(\\[.*?\\]);";
                String initDataValue = scriptContent.replaceAll("\\s", "").replaceAll(regex, "$1");
                String regex1 = "\"productId\":\\s*\"(.*?)\"";

                // Tạo đối tượng Pattern từ mẫu regex
                Pattern pattern = Pattern.compile(regex1);

                // Tạo đối tượng Matcher
                Matcher matcher = pattern.matcher(initDataValue);

                // Lặp qua tất cả các kết quả khớp
//                while (matcher.find()) {
//                    // Lấy giá trị của nhóm trùng khớp (group 1)
//                    String productValue = matcher.group(1);
//                    product(productValue);
//                    // In giá trị
//                    System.out.println("Found product: " + productValue);
//                }
                product("1005006103601520");
            } else {
                System.out.println("Không tìm thấy phần tử script chứa window._dida_config_._init_data_");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static void product(String id){
        String url = "https://vi.aliexpress.com/item/"+ id +".html";

        try {
            Document document = Jsoup.connect(url).get();
//            System.out.println(document);
//            System.out.println("----------------------------------------------------");
            // Sử dụng querySelector để lấy phần tử script chứa window.runParams
            Element scriptElement = document.select("script:containsData(window.runParams)").first();
//            System.out.println(scriptElement);
            // Kiểm tra xem có phần tử script không
            if (scriptElement != null) {
                // Lấy nội dung của script
                String scriptContent = scriptElement.html();

                // Sử dụng regex để trích xuất giá trị của window.runParams
                String regex = "window\\.runParams\\s*=\\s*\\{(.*?)};";
                String runParamsValue = scriptContent.replaceAll("\\s", "").replaceAll(regex, "$1");

                // In giá trị của window.runParams
//                System.out.println("1");
//                System.out.println("window.runParams: " + runParamsValue);
                // Convert to JSONObject
                String jsonValue = runParamsValue.substring(runParamsValue.indexOf("{"), runParamsValue.lastIndexOf("}") + 1);

                // Convert to JsonObject using Gson
                JsonObject jsonObject = new Gson().fromJson(jsonValue, JsonObject.class);
//                appendJsonToFile( jsonObject);
                // Print the JsonObject
                System.out.println( jsonObject.toString());

                // Print the JSON object
            } else {
                System.out.println("Không tìm thấy phần tử script chứa window.runParams");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
