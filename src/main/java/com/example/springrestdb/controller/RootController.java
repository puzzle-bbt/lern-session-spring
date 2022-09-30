package com.example.springrestdb.controller;

import com.example.springrestdb.ExampleProperties;
import com.example.springrestdb.service.ExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class RootController {

    @Autowired
    ExampleProperties exampleProperties;

    @Autowired
    ExampleService exampleService;

    private static final Logger LOG = LoggerFactory.getLogger(RootController.class);

    @GetMapping("string")
    @ResponseBody
    public String string() {
        LOG.info("Get common string.");
        return exampleService.getInfo();
    }

    @GetMapping("listOfString")
    @ResponseBody
    public List<String> listOfString() {
        LOG.info("Get common infos.");
        return exampleProperties.getCompanies();
    }

    @GetMapping("map")
    @ResponseBody
    public Map<String,String> map() {
        LOG.info("Get common infos.");
        return exampleProperties.getFruits();
    }
}
