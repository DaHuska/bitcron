package bg.softuni.bitchron.service.impl;

import bg.softuni.bitchron.model.dto.UserRegisterDTO;
import bg.softuni.bitchron.model.entity.UserEntity;
import bg.softuni.bitchron.model.entity.UserRoleEntity;
import bg.softuni.bitchron.model.enums.UserRole;
import bg.softuni.bitchron.repository.RoleRepository;
import bg.softuni.bitchron.repository.UserRepository;
import bg.softuni.bitchron.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserRegisterDTO user) {
        Optional<UserEntity> foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser.isPresent()) {
            //TODO: Handle UserExisting Exception
            return;
        }

//        UserEntity newUser = map(user);
    }

//    private static UserEntity map(UserRegisterDTO userRegisterDTO) {
//        return new UserEntity()
//                .setFirstName(userRegisterDTO.getFirstName())
//                .setLastName(userRegisterDTO.getLastName())
//                .setUsername(userRegisterDTO.getUsername())
//                .setRoles(List.of(UserRole.USER));
//    }
}
