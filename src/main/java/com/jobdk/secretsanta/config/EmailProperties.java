package com.jobdk.secretsanta.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("property")
public class EmailProperties {
  private String email;
  private String password;
}
