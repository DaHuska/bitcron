package bg.softuni.bitchron.config;

import bg.softuni.bitchron.model.enums.UserRole;
import bg.softuni.bitchron.repository.UserRepository;
import bg.softuni.bitchron.service.impl.BitChronUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
@EnableCaching
public class SecurityConfiguration {
    private final String rememberMeKey;

    public SecurityConfiguration(@Value("${bitcron.remember.me.key}") String rememberMeKey) {
        this.rememberMeKey = rememberMeKey;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // Define which urls are visible by which users
        httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        // All static resources which are situated in js, images, css are available for anyone
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // Requests anybody can see
                        .requestMatchers("/", "/users/login", "/users/register", "/users/logout").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/products/watches", "/products/watches/{id}").permitAll()
                        .requestMatchers("/error", "/errors/404").permitAll()
                        .requestMatchers("/products/create-offer", "/products/add-watch").hasRole(String.valueOf(UserRole.ADMIN))
                        // Authenticated requests
                        .requestMatchers("/users/user-{id}", "/users/user-{id}/edit-profile").authenticated()
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
        ).rememberMe(
                rememberMe -> {
                    rememberMe
                            .key(this.rememberMeKey)
                            .rememberMeParameter("rememberme")
                            .rememberMeCookieName("rememberme");
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

    @Bean
    public MultipartResolver multipartResolver() {
        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();

        return multipartResolver;
    }
}
