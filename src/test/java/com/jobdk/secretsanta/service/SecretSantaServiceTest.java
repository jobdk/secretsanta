package com.jobdk.secretsanta.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.jobdk.secretsanta.model.Person;
import com.jobdk.secretsanta.model.SecretSanta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecretSantaServiceTest {

  @Mock EmailService emailServiceMock;
  SecretSantaService unitUnderTest;

  @BeforeEach
  void beforeEach() {
    unitUnderTest = new SecretSantaService(emailServiceMock);
  }

  List<Person> persons =
      Arrays.asList(
          new Person("John", "john"),
          new Person("Jane", "jane"),
          new Person("Joe", "joe"),
          new Person("Jill", "jill"));

  @Test
  void testShuffle() {
    // Arrange
    List<Person> original = new ArrayList<>(persons);

    // Act
    List<SecretSanta> result = unitUnderTest.shuffle(persons, original);

    // Assert
    assertEquals(4, result.size());
    for (SecretSanta secretSanta : result) {
      assertNotEquals(secretSanta.giver(), secretSanta.receiver());
    }
  }

  @Test
  void testSecretSantas() {
    // Arrange
    // Act
    unitUnderTest.sendSecretSantas(persons);

    // Assert
    verify(emailServiceMock, times(4)).sendEmail(anyString(), anyString(), anyString());
  }
}