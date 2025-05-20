package bg.softuni.bitchron.service.impl;

import bg.softuni.bitchron.model.dto.UserEditDTO;
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
import java.util.Date;
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
        UserEntity newUser = map(user, userRepository, roleRepository, modelMapper);

        userRepository.save(newUser);
    }

    @Override
    public void editUserProfile(UserEditDTO userEditDTO) {
        UserEntity user = map(userEditDTO, userRepository, modelMapper);

        userRepository.save(user);
    }

    private static UserEntity map(UserEditDTO userEditDTO, UserRepository userRepository, ModelMapper modelMapper) {
        UserEntity user = userRepository.findById(userEditDTO.getId()).get();

        modelMapper.map(userEditDTO, user);

        return user.setModified(new Date());
    }

    private static UserEntity map(UserRegisterDTO userRegisterDTO,
                                  UserRepository userRepository,
                                  RoleRepository roleRepository,
                                  ModelMapper modelMapper) {
        UserEntity user = new UserEntity();
        
        modelMapper.map(userRegisterDTO, user);

        return user.setRoles(mapRoles(userRepository, roleRepository));
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
