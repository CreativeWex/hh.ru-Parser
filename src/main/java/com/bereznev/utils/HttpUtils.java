package com.bereznev.utils;
/*
    =====================================
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import com.bereznev.dto.ErrorDTO;
import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Log4j
public class HttpUtils {

    private HttpUtils() {
    }

    public static String sendHttpRequest(String url, String resource) {
        int responseCode = 500;
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");

            responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("Request sending error. Response status: " + responseCode);
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }

            bufferedReader.close();
            connection.disconnect();
            return response.toString();
        } catch (IOException e) { //FIXME
            ErrorDTO.responseCode = responseCode;
            ErrorDTO.resourceName = resource;
            log.error(e.getMessage());
            return "";
        }
    }
}
