package com.mockwebserver.webclient;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockwebserver.webclient.model.Json;
import com.mockwebserver.webclient.service.UserClient;
import com.mockwebserver.webclient.webclientproperties.Properties;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@SpringBootTest
public class WebClientTests {

    public static MockWebServer mockWebServer;

    static UserClient userClient;

    public static ObjectMapper objectMapper;


    @BeforeAll
    static void setUp() throws IOException {

        objectMapper = new ObjectMapper();

        mockWebServer = new MockWebServer();
        mockWebServer.start(9042);

        Properties properties = new Properties();
        properties.uri = mockWebServer.url("/mockWebServer/").url().toString();

        userClient = new UserClient(WebClient.create(), properties);

    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }


    @Test
    void getPhoneDetails() throws Exception {

        Json json = new Json();
        json.setTitle("Iphone X");

//        String json = "{\"title\": \"iphone\"}";

        MockResponse mockResponse = new MockResponse()
                .setBody(objectMapper.writeValueAsString(json))
                .addHeader("Content-Type", "application/json");


        mockWebServer.enqueue(mockResponse);


        userClient.json();


    }
}
