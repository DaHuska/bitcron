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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
    public void register(UserRegisterDTO user) throws Exception {
        Optional<UserEntity> foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser.isPresent()) {
            throw new Exception("Username not available!");
        }

        user.setPassword(encodePassword(user.getPassword()));
        UserEntity newUser = map(user, userRepository, roleRepository);

        userRepository.save(newUser);
    }

    private static UserEntity map(UserRegisterDTO userRegisterDTO, UserRepository userRepository, RoleRepository roleRepository) {
        return new UserEntity()
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setUsername(userRegisterDTO.getUsername())
                .setPassword(userRegisterDTO.getPassword())
                .setRoles(mapRoles(userRepository, roleRepository));
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private static List<UserRoleEntity> mapRoles(UserRepository userRepository, RoleRepository roleRepository) {
        checkRoles(roleRepository);

        List<UserRoleEntity> roles = new ArrayList<>();
        if (userRepository.findAll().isEmpty()) {
            UserRoleEntity admin = roleRepository.findById(1L).get();
            roles.add(admin);
        }

        UserRoleEntity user = roleRepository.findById(2L).get();
        roles.add(user);

        return roles;
    }

    private static void checkRoles(RoleRepository repo) {
        if (repo.findAll().isEmpty()) {
            registerRoles(repo);
        }
    }

    private static void registerRoles(RoleRepository repo) {
        UserRoleEntity admin = new UserRoleEntity();
        admin.setRole(UserRole.ADMIN);

        repo.save(admin);

        UserRoleEntity user = new UserRoleEntity();
        user.setRole(UserRole.USER);

        repo.save(user);
    }
}
