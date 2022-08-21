package com.pca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingControlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingControlApiApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("P@ssw0rd"));
    }

    @GetMapping("/")
    public String root() {
        return "Hello World!";
    }
}
