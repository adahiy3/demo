package com.example.springboot.demo.configuration;

import com.example.springboot.demo.model.Mail;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleBeanConfig {

@ConfigurationProperties(prefix = "mail")
    @Bean
    public Mail mail(){

     return new Mail();

    }
}
