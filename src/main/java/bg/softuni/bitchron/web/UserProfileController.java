package bg.softuni.bitchron.web;

import bg.softuni.bitchron.model.entity.UserEntity;
import bg.softuni.bitchron.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserProfileController {
    private final UserRepository userRepository;

    public UserProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user-{id}")
    public String getProfileInfo(@PathVariable("id") Long id, Model model) {
        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isEmpty()) {
            // TODO: handle exception
        }

        if (!model.containsAttribute("user")) {
            model.addAttribute("user", user.get());
        }

        return "user-profile";
    }

    @GetMapping("/user-{id}/edit-profile")
    public String getEditProfile(@PathVariable("id") Long id, Model model) {
        // TODO: create edit-profile page
        return "";
    }

    @PostMapping("/user-{id}/edit-profile")
    public String editProfile(@PathVariable("id") Long id,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isEmpty()) {
            // TODO: handle exception
        }

        return "redirect:/";
    }
}
