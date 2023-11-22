package com.jobdk.secretsanta;

import com.jobdk.secretsanta.config.EmailProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EmailProperties.class)
public class SecretsantaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretsantaApplication.class, args);
    }

}
