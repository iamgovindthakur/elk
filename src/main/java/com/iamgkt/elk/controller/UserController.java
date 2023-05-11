package com.iamgkt.elk.controller;

import com.iamgkt.elk.correlation.CorrelationIdHolder;
import com.iamgkt.elk.model.User;
import com.iamgkt.elk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        String correlationId = CorrelationIdHolder.getCorrelationId();
        logger.info("Received request to get users. Correlation ID: {}", correlationId);
        return userService.getUsers();
    }
}
