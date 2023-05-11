package com.iamgkt.elk.service;

import com.iamgkt.elk.correlation.CorrelationIdHolder;
import com.iamgkt.elk.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<User> getUsers() {
        String correlationId = CorrelationIdHolder.getCorrelationId();
        logger.info("Processing getUsers request. Correlation ID: {}", correlationId);
        return generateUsers();
    }

    private List<User> generateUsers() {
        String correlationId = CorrelationIdHolder.getCorrelationId();
        logger.info("Generating users. Correlation ID: {}", correlationId);
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String id = String.valueOf(i);
            String name = generateRandomName();
            User usr = new User(id, name);
            logger.info("User Generated: {}", usr);
            users.add(usr);
        }
        return users;
    }


    private String generateRandomName() {
        String[] names = {"John", "Jane", "Alice", "Bob", "Charlie", "Emma", "David", "Olivia", "Liam", "Sophia"};
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);
        return names[randomIndex];
    }
}
