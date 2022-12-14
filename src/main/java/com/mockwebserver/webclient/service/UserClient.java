package com.mockwebserver.webclient.service;

import com.mockwebserver.webclient.model.Json;
import com.mockwebserver.webclient.webclientproperties.Properties;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UserClient {

    WebClient webClient;

    Properties properties;

    public UserClient(WebClient webClient, Properties properties) {
        this.properties = properties;
        this.webClient = WebClient.create(properties.uri);
    }

    public Json json() {
        return webClient.get()
                .uri("products/2")
                .retrieve()
                .bodyToMono(Json.class)
                .block();
    }

}
