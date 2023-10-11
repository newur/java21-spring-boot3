package com.example;

import com.example.demo.dto.AbstractPackage;
import com.example.demo.dto.HeavyPackage;
import com.example.demo.dto.LightPackage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class ControllerCaller {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        LightPackage lightPackage = new LightPackage("I am light");
        HeavyPackage heavyPackage = new HeavyPackage("I am heavy", 777);
        List<AbstractPackage> greetings = List.of(heavyPackage, lightPackage);
        String greetingsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(greetings);
        System.out.println(greetingsJson);

        HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://localhost:8080/packages"))
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .POST(HttpRequest.BodyPublishers.ofString(greetingsJson))
                .build();

        try(HttpClient httpClient = HttpClient.newHttpClient()) {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
