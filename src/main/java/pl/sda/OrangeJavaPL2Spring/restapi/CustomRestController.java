package pl.sda.OrangeJavaPL2Spring.restapi;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@RestController //definicja beana
public class CustomRestController {


    // @RequestMapping(method = RequestMethod.GET,path = "/hello")
    // Adnotacja tak samo działa jak GetMapping
    @GetMapping(path = "/hello")
    public String helloDev(){
        return "hello Dev";
    }

}
