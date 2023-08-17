package dev.unscrud.mudi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        request.setAttribute("nome", "unscrud");
        return "hello";
    }
}
