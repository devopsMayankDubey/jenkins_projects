package com.example.radical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class devops {
    @GetMapping("/devops")
    public String getData() {
        return "In devops we learn CI/CD";
    }
}