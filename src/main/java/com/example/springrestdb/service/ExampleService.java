package com.example.springrestdb.service;

import com.example.springrestdb.ExampleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    ExampleProperties properties;

    public String getInfo() {
        ExampleProperties.Server serverProperties = properties.getServer();

        return "application name:" +
                properties.getApplicationName() +
                ", application name:" +
                serverProperties.getName() +
                ", application host:" +
                serverProperties.getHost();
    }
}
