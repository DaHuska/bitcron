package bg.softuni.bitchron.service.impl;

import bg.softuni.bitchron.model.dto.UserRegisterDTO;
import bg.softuni.bitchron.model.entity.UserEntity;
import bg.softuni.bitchron.model.entity.UserRoleEntity;
import bg.softuni.bitchron.model.enums.UserRole;
import bg.softuni.bitchron.repository.UserRepository;
import bg.softuni.bitchron.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserRegisterDTO user) {
        Optional<UserEntity> foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser.isPresent()) {
            // Throw exception
            return;
        }

        UserEntity newUser = map();
    }

    private static UserEntity map(UserRegisterDTO userRegisterDTO) {
        return new UserEntity()
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setUsername(userRegisterDTO.getUsername())
                .setRoles(List.of(UserRole.USER));
    }
}
