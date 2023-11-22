package com.jobdk.secretsanta.service;

import static org.mockito.Mockito.*;

import com.jobdk.secretsanta.config.EmailProperties;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class EmailServiceTest {
  @Autowired EmailService unitUnderTest;
  @MockBean JavaMailSender mailSender;
  @Autowired EmailProperties emailProperties;

  @Test
  void testSendEmail() {
    // Arrange
    // Act
    unitUnderTest.sendEmail("testaccdummy1980@gmail.com", "Santa is in", "Howdy!");

    // Assert
    verify(mailSender, times(1)).send(Mockito.<SimpleMailMessage>any());
  }
}
