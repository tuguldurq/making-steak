package com.project.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @GetMapping("/hi")
    public String hi() {
        return new String("Hi");
    }
    
}
