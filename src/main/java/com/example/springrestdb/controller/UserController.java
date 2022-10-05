package com.example.springrestdb.controller;

import com.example.springrestdb.model.User;
import com.example.springrestdb.repository.UserRepository;
import com.example.springrestdb.service.ExampleMatcherService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExampleMatcherService exampleMatcherService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "If 'email' is empty returned all users. Otherwise all users with the specified e-mail.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Did not find a users with a specified e-mail.", content = @Content)
    })
    @GetMapping("users")
    public List<User> getAllUsers(@RequestParam(required = false) String email) {
        if (ObjectUtils.isEmpty(email)) {
            LOG.info("getAllUsers");
            return (List<User>) exampleMatcherService.getAllUser();
        }
        LOG.info("getAllUsers with E-Mail '{}'", email);
        return (List<User>) exampleMatcherService.getUserByEMail(email);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned a users with a specified ID.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Did not find a users with a specified ID.", content = @Content)
    })
    @GetMapping("users/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
        return userRepository.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returned all users with a '@puzzle.ch' e-mail.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Did not find any users with a '@puzzle.ch' e-mail.",
                    content = @Content)
    })
    @GetMapping("puzzle-users")
    public List<User> getAllPuzzleUser() {
        LOG.info("getAllPuzzleUser");
        return (List<User>) exampleMatcherService.getAllPuzzleUser();
    }
}
