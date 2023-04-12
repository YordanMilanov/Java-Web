package bg.softuni.pizzashop.config;

import bg.softuni.pizzashop.repository.UserRepository;
import bg.softuni.pizzashop.service.UserDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public SecurityConfiguration(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/menu")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/about")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/users/login")).anonymous()
                .requestMatchers(new AntPathRequestMatcher("/users/register")).anonymous()
                .anyRequest().authenticated()
                .and()
                //until here the above is one statement after and() we start doing second statement for the same httpSecurity object

                //now we change the default .formLogin() of spring security to our custom
                .formLogin()
                //path to our custom page
                .loginPage("/users/login")
                //this method requires the name of the <input name="username"> as a parameter.
                .usernameParameter("username")
                //this method requires the name of the <input name="password"> as a parameter.
                .passwordParameter("password")
                //successful redirect point
                .defaultSuccessUrl("/")
                //redirect if not successful and we add query parameter so we can render an error in the html for example error=true
                .failureForwardUrl("/users/login?error=true");

//                httpSecurity.authorizeHttpRequests()
//                .requestMatchers("/users/login", "users/register").anonymous();
//                .and().formLogin().loginPage("/users/login").and().authorizeHttpRequests()
//                .and().formLogin().and().build();

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService () {
        return new UserDetailService(userRepository);
    }
}