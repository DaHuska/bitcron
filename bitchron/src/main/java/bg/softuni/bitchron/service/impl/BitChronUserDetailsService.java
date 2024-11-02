package bg.softuni.bitchron.service.impl;

import bg.softuni.bitchron.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class BitChronUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public BitChronUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    }
}
