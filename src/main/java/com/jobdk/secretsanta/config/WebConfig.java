package com.jobdk.secretsanta.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class WebConfig {

  @Bean
  public JavaMailSender getJavaMailSender(EmailProperties emailProperties) {
    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    javaMailSender.setPort(587);
    javaMailSender.setHost("smtp.gmail.com");

    javaMailSender.setUsername(emailProperties.getEmail());
    javaMailSender.setPassword(emailProperties.getPassword());

    Properties javaMailProperties = javaMailSender.getJavaMailProperties();
    javaMailProperties.put("mail.smtp.starttls.enable", "true");
    javaMailProperties.put("mail.transport.protocol", "smtp");
    javaMailProperties.put("mail.debug", "true");
    javaMailProperties.put("mail.smtp.auth", "true");
    return javaMailSender;
  }
}
