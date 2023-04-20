package pl.sda.OrangeJavaPL2Spring.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NextRestController {

    @GetMapping("/siema")
    public String hello(){
        return "siemka";
    }
}
