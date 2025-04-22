package bg.softuni.bitchron.web;

import bg.softuni.bitchron.model.dto.WatchDTO;
import bg.softuni.bitchron.service.ProductService;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/watches")
    public String watches() {
        return "watches";
    }

    @GetMapping("/add-watch")
    public String addWatch(Model model) {
        if (!model.containsAttribute("watchDTO")) {
            model.addAttribute("watchDTO", new WatchDTO());
        }

        return "add-watch";
    }

    @PostMapping("/add-watch")
    public String addWatch(@Valid WatchDTO watchDTO, @RequestParam("productImage") MultipartFile image,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("watchDTO", watchDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.watchDTO", bindingResult);

            return "redirect:/products/add-watch";
        }

        productService.addProduct(watchDTO, image);

        return "redirect:/products/watches";
    }
}
