package bg.softuni.bitchron.config;

import bg.softuni.bitchron.repository.UserRepository;
import bg.softuni.bitchron.service.impl.BitChronUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // Define which urls are visible by which users
        httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        // All static resources which are situated in js, images, css are available for anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // Allow anyone to see
                        .requestMatchers("/", "/users/login", "/users/register", "/users/logout").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/watches").permitAll()
                        // status code 999 error
                        .requestMatchers("/error").permitAll()
                        // All other requests are authenticated
                        .anyRequest().authenticated()

        ).formLogin(
                formLogin -> {
                    // Redirect here when we access something which is not allowed
                    formLogin
                            .loginPage("/users/login")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/users/login-error");
                }
        ).logout(
                logout -> {
                    logout.
                            logoutUrl("/users/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true);
                }
        );

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new BitChronUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
