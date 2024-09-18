package com.ifeanyi.cinema_house.auth.config;

import com.ifeanyi.cinema_house.auth.filter.JwtFilter;
import com.ifeanyi.cinema_house.auth.service.AuthService;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRequestHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.function.Supplier;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    private final String[] openUrls = {"/api/user/create", "/api/user/login", "/api/user/otp/generate", "/api/user/password"};
    //    private final UserService userService;
    private final JwtFilter jwtFilter;

    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(authService.userDetails());

        return provider;
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring()
//                .dispatcherTypeMatchers(DispatcherType.ERROR)
//                .mvcMatchers("/foo");
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**")
                        .permitAll()
                        .requestMatchers("/**").hasRole("USER")
                        .anyRequest()
                        .authenticated())
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//        httpSecurity.authenticationProvider(authenticationProvider());
//        httpSecurity.httpBasic(Customizer.withDefaults());


        return httpSecurity.build();
    }

}