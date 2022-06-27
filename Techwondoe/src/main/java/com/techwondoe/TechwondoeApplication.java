package com.techwondoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
@EnableSwagger2
public class TechwondoeApplication {

  public static void main(String[] args) {
    SpringApplication.run(TechwondoeApplication.class, args);
  }

}
