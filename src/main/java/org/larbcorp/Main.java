package org.larbcorp;

import org.larbcorp.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        RestTemplate restTemplate = new RestTemplate();
        User newUser = new User(1L, "newuser", "newuser@example.com", "password", 100.00);
        User createdUser = restTemplate.postForObject("http://localhost:8080/users", newUser, User.class);

        System.out.println(newUser);


    }
}
