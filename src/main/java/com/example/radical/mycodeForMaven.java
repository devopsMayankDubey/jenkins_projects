package com.example.radical;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mycodeForMaven {
    @GetMapping("/mycodeForMaven")
    public String getData() {
        return "This is me again awesome just ode  by  again";
    }
}
