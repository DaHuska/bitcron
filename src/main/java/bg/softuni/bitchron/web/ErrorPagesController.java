package bg.softuni.bitchron.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errors")
public class ErrorPagesController {
    @GetMapping("/404")
    public String notFoundError() {
        return "404";
    }
}
