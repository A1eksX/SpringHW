package com.example.HW7v1;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebController {
    @GetMapping("/user")
    public String usersPage(){
        return "user.html";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin.html";
    }
    @GetMapping("/index")
    public String index(){
        return "index.html";
    }
}
