package bg.softuni.bitchron.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewProductController {
    @GetMapping("/add-watch")
    public String addWatch() {
        return "add-watch";
    }
}
