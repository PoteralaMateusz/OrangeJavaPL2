package pl.sda.OrangeJavaPL2Spring.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstRestController {

    @GetMapping("/hello-world")
    public String hello(){
        return "Cześć";
    }
}
