package com.fila.Spring_Boo_.and_Thymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String adm(){
        return "admin";
    }
}
