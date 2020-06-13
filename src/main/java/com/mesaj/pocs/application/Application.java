package com.mesaj.pocs.application;

import com.mesaj.pocs.application.entities.User;
import com.mesaj.pocs.application.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository){
        return args -> {
            Stream.of("Julian", "Pepitp", "Goku", "Kamisama").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@gmail.com");
                userRepository.save(user);
            });

            userRepository.findAll().forEach(System.out::println);
        };
    }

}
