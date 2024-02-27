package com.example.demo.service.woocommerce;

import com.example.demo.util.model.aliexpress.ProductAliExpress;
import com.example.demo.util.model.woocommerce.Product;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class WoocommerceService {

    public  void saveProduct(ProductAliExpress productAliExpress)  {
        try {
            String url = "http://thangdfg.atwebpages.com/wp-json/wc/v3/products";
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Set the request method
            connection.setRequestMethod("POST");

            // Set request headers
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Basic cm9vdDpJbG92ZXlvdTE0OSE=");
            connection.setRequestProperty("Cookie", "mailpoet_page_view=%7B%22timestamp%22%3A1706339519%7D; tk_ai=jetpack%3AnO%2BULYj%2FgREF1r8BfYYNVBsr");

            // Enable input/output streams
            connection.setDoOutput(true);

            // Set request body
            Gson gson = new Gson();

            Product product = new Product(productAliExpress);
            String requestBody = gson.toJson(product);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(requestBody);
            wr.flush();
            wr.close();

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response
            System.out.println("Response: " + response.toString());
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
