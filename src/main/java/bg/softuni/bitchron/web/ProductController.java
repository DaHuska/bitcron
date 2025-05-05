package bg.softuni.bitchron.web;

import bg.softuni.bitchron.model.dto.OfferRegisterDTO;
import bg.softuni.bitchron.model.dto.WatchDTO;
import bg.softuni.bitchron.model.entity.OfferEntity;
import bg.softuni.bitchron.model.entity.WatchEntity;
import bg.softuni.bitchron.repository.OfferRepository;
import bg.softuni.bitchron.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final OfferRepository offerRepository;

    public ProductController(ProductService productService, OfferRepository offerRepository) {
        this.productService = productService;
        this.offerRepository = offerRepository;
    }

    @GetMapping("/watches")
    public String watches(Model model) {
        List<OfferEntity> offers = productService.getAllOffers();

        model.addAttribute("offers", offers);

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
    public String addWatch(@Valid WatchDTO watchDTO, @NotNull @RequestParam("productImage") MultipartFile image,
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

    @GetMapping("/create-offer")
    public String createOffer(Model model) {
        if (!model.containsAttribute("offerDTO")) {
            model.addAttribute("offerDTO", new OfferRegisterDTO());
        }

        List<WatchEntity> watches = productService.getAllWatches();

        model.addAttribute("watches", watches);

        return "create-offer";
    }

    @PostMapping("/create-offer")
    public String createOffer(@Valid OfferRegisterDTO offerRegisterDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerDTO", offerRegisterDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerDTO", bindingResult);

            return "redirect:/products/create-offer";
        }

        Optional<WatchEntity> watch = productService.getWatchById(Long.valueOf(offerRegisterDTO.getWatch()));

        if (watch.isEmpty()) {
            bindingResult.addError(new ObjectError("watchError", "Watch not found!"));
        }

        productService.createOffer(offerRegisterDTO, watch.get());

        return "redirect:/products/watches";
    }

    @GetMapping("/watches/{id}")
    public String getProductByID(@PathVariable("id") Long offerID, Model model) {
        Optional<OfferEntity> offer = offerRepository.findById(offerID);

        if (offer.isEmpty()) {
//            TODO: Validate invalid access link
        }

        model.addAttribute("offer", offer.get());

        return "product-page";
    }
}
