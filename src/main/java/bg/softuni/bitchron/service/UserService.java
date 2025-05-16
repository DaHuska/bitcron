package bg.softuni.bitchron.service;

import bg.softuni.bitchron.model.dto.UserEditDTO;
import bg.softuni.bitchron.model.dto.UserRegisterDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    void register(UserRegisterDTO user) throws Exception;
    void editUserProfile(UserEditDTO userEditDTO);
}
