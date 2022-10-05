package com.example.springrestdb.controller;

import com.example.springrestdb.model.User;
import com.example.springrestdb.service.ExampleMatcherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ExampleMatcherService exampleMatcherService;

    @GetMapping("users")
    public List<User> getAllUsers(@RequestParam(required = false) String email) {
        if (ObjectUtils.isEmpty(email)) {
            LOG.info("getAllUsers");
            return (List<User>) exampleMatcherService.getAllUser();
        }
        LOG.info("getAllUsers with E-Mail '{}'", email);
        return (List<User>) exampleMatcherService.getUserByEMail(email);
    }

    @GetMapping("puzzle-users")
    public List<User> getAllPuzzleUser() {
        LOG.info("getAllPuzzleUser");
        return (List<User>) exampleMatcherService.getAllPuzzleUser();
    }
}
