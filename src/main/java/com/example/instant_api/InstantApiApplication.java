package com.example.instant_api;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InstantApiApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InstantApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(InstantApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsMappingConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .maxAge(3600)
                        .allowedHeaders("*")
                        .exposedHeaders("*");
            }
        };
    }

    @Override
    @Transactional
    public void run(String... args) {

    }
}
