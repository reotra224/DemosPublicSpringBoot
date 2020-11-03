package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringbootDocDemoApplication {
    private static Logger logger = LoggerFactory.getLogger(SpringbootDocDemoApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootDocDemoApplication.class, args);
        SpringApplication app = new SpringApplication(SpringbootDocDemoApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.addListeners(applicationEvent -> logger.info("========== EVENT: {}", applicationEvent));
        app.run(args);
    }

    @Bean
    CommandLineRunner start(BirdsRepository repository) {
        return args -> {
            Arrays.asList("Péroquet", "Colibri", "Wada", "crook").forEach(s -> {
                repository.save(new Birds(null, s));
            });
            repository.findAll().forEach(System.out::println);
        };
    }

}
