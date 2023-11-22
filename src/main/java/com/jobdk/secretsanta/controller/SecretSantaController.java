package com.jobdk.secretsanta.controller;

import com.jobdk.secretsanta.model.Person;
import com.jobdk.secretsanta.service.SecretSantaService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SecretSantaController {

  private final SecretSantaService secretSantaService;

  public SecretSantaController(SecretSantaService secretSantaService) {
    this.secretSantaService = secretSantaService;
  }

  @PostMapping("/sendsecretsantas")
  public void sendSecretSantas(@RequestBody List<Person> persons) {
    secretSantaService.sendSecretSantas(persons);
  }
}
