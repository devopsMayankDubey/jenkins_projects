package com.example.radical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testMicro {
    @GetMapping("/testMicro")
    public String getData() {
        return "Just testing ......";
    }
}
