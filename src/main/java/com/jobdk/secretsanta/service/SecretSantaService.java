package com.jobdk.secretsanta.service;

import com.jobdk.secretsanta.model.Person;
import com.jobdk.secretsanta.model.SecretSanta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class SecretSantaService {
  private final EmailService emailService;

  public SecretSantaService(EmailService emailService) {
    this.emailService = emailService;
  }

  public void sendSecretSantas(List<Person> persons) {
    List<Person> original = new ArrayList<>(persons);
    List<SecretSanta> result = shuffle(persons, original);
    result.forEach(
        secretSanta ->
            emailService.sendEmail(
                secretSanta.giver().email(),
                "Weihnachtsgeschenk",
                secretSanta.giver().name()
                    + " hat "
                    + secretSanta.receiver().name()
                    + " gezogen."));
  }

  protected List<SecretSanta> shuffle(List<Person> shuffled, List<Person> original) {
    List<SecretSanta> result;
    while (true) {
      Collections.shuffle(shuffled);
      if (everyBodyHasSomeoneElse(shuffled, original)) {
        result =
            IntStream.range(0, shuffled.size())
                .mapToObj(i -> new SecretSanta(shuffled.get(i), original.get(i)))
                .toList();
        break;
      }
    }
    return result;
  }

  private boolean everyBodyHasSomeoneElse(List<Person> shuffled, List<Person> original) {
    return IntStream.range(0, shuffled.size())
        .noneMatch(i -> shuffled.get(i).name().equals(original.get(i).name()));
  }
}
