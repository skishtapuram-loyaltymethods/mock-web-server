package com.mockwebserver.webclient;

import com.mockwebserver.webclient.model.Json;
import com.mockwebserver.webclient.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WebclientApplication {
    @Autowired
    UserClient userClient;


    public static void main(String[] args) {
        SpringApplication.run(WebclientApplication.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        Json json = userClient.json();
        System.out.println(json);
    }

}
