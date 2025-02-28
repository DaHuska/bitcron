package bg.softuni.bitchron.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavbarController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/watches")
    public String watches() {
        return "watches";
    }
}
