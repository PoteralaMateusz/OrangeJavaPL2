package pl.sda.OrangeJavaPL2Spring.restapi;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("prod")
@RestController
public class MyFirstRestController {

    @GetMapping("/hello")
    public String hello(){
        return "Cześć Prod";
    }
}
