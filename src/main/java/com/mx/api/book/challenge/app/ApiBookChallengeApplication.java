package com.mx.api.book.challenge.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@SpringBootApplication
public class ApiBookChallengeApplication {



    public static void main(String[] args) {
        SpringApplication.run(ApiBookChallengeApplication.class, args);
    }





}
