package pl.sda.OrangeJavaPL2Spring.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.OrangeJavaPL2Spring.configuration.WelcomeMessage;

@Profile("dev")
@RestController //definicja beana
@RequiredArgsConstructor
public class CustomRestController {

    private final WelcomeMessage welcomeMessage;
    // @RequestMapping(method = RequestMethod.GET,path = "/hello")
    // Adnotacja tak samo działa jak GetMapping
    @GetMapping(path = "/hello")
    public String helloDev(){
        return "hello Dev " + welcomeMessage.getValue();
    }

}
