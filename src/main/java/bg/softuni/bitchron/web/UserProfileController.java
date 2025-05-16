package bg.softuni.bitchron.web;

import bg.softuni.bitchron.model.dto.UserEditDTO;
import bg.softuni.bitchron.model.entity.UserEntity;
import bg.softuni.bitchron.repository.UserRepository;
import bg.softuni.bitchron.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
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
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserProfileController(UserRepository userRepository, UserService userService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/user-{id}")
    public String getProfileInfo(@PathVariable("id") Long id, Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", findUser(id));
        }

        return "user-profile";
    }

    @GetMapping("/user-{id}/edit-profile")
    public String getEditProfile(@PathVariable("id") Long id, Model model) {
        if (!model.containsAttribute("editUserDTO")) {
            UserEditDTO userEditDTO = mapUser(id);

            model.addAttribute("userEditDTO", userEditDTO);
            model.addAttribute("userId", id);
        }

        return "edit-profile";
    }

    @PostMapping("/user-{id}/edit-profile")
    public String editProfile(@PathVariable("id") Long id,
                                  @Valid UserEditDTO userEditDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userEditDTO", userEditDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userEditDTO", bindingResult);

            return "redirect:/users/user-" + id + "/edit-profile";
        }

        userService.editUserProfile(userEditDTO);

        return "redirect:/";
    }

    private UserEntity findUser(Long id) {
        //TODO: Fix service to find user and not repo
        Optional<UserEntity> user = userRepository.findById(id);

        if (user.isEmpty()) {
            // TODO: handle exception
        }

        return user.get();
    }

    // Populate already available fields
    private UserEditDTO mapUser(Long id) {
       return modelMapper.map(findUser(id), UserEditDTO.class);
    }
}
