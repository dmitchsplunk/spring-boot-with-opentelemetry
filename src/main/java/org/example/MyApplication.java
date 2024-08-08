package org.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
@SpringBootApplication
public class MyApplication {

    @RequestMapping("/ping")
    String home() {

        RestTemplate restTemplate = new RestTemplate();
        String pongUrl
                = "http://localhost:8090/pong";
        ResponseEntity<String> response
                = restTemplate.getForEntity(pongUrl, String.class);
        String result = response.getBody();
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}