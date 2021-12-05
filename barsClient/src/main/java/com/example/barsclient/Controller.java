package com.example.barsclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Controller {

    private static String fetchContent(String uri) throws IOException {
        final int OK = 200;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int responseCode = connection.getResponseCode();
        if(responseCode == OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        }
        return null;
    }

    public static Contract getData() throws IOException {
        String url = "http://localhost:8080";

        String content = fetchContent(url);
        Gson gson = new GsonBuilder().registerTypeAdapter(Contract.class, new JsonDeserializerContract())
                .serializeNulls().create();

        return gson.fromJson(content, new TypeToken<Contract>(){}.getType());
    }


}