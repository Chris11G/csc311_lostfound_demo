package edu.farmingdale.csc311.lostfound.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Passwords are stored as BCrypt hashes (they start with $2a$)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Anyone may open these pages
                .requestMatchers("/register", "/login", "/error", "/h2-console/**").permitAll()
                // Every other page requires sign-in
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")              // our own sign-in page
                .defaultSuccessUrl("/", true)     // after signing in, go to /
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout") // after signing out
                .permitAll()
            )
            // The H2 console posts forms without our CSRF token and runs inside frames
            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }
}
