package pl.sda.OrangeJavaPL2Spring.restapi;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@RestController
public class CustomRestController {

    @GetMapping(path = "/hello")
    public String helloDev(){
        return "hello Dev";
    }

}
