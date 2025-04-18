package bg.softuni.bitchron.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @GetMapping("/add-watch")
    public ModelAndView addWatch() {
        return new ModelAndView("add-watch");
    }


}
