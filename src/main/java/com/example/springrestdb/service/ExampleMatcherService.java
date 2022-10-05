package com.example.springrestdb.service;

import com.example.springrestdb.model.User;
import com.example.springrestdb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;

/**
 * Examples of ExampleMatcher.matching(): https://www.baeldung.com/spring-data-query-by-example
 */
@Controller
public class ExampleMatcherService {
    private static final Logger LOG = LoggerFactory.getLogger(ExampleMatcherService.class);
    @Autowired
    UserRepository userRepository;

    public Iterable<User> getAllUser() {
        LOG.info("getAllUser");
        Example<User> exampleUser = Example.of(User.builder().build());
        return userRepository.findAll(exampleUser);
    }

    public Iterable<User> getUserByEMail(String email) {
        LOG.info("getUserByEMail '{}'", email);
        Example<User> exampleUser = Example.of(User.builder().email(email).build());
        return userRepository.findAll(exampleUser);
    }
    public Iterable<User> getAllPuzzleUser() {
        LOG.info("getAllPuzzleUser");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<User> exampleUser = Example.of(User.builder().email("@puzzle.ch").build(), matcher);
        return userRepository.findAll(exampleUser);
    }
}
