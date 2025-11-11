package br.com.alexandrejnrx.controlprodapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    private SecurityFilter securityFilter;

    public SecurityConfiguration(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users").authenticated()
                        .requestMatchers(HttpMethod.GET, "/users/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/products").authenticated()
                        .requestMatchers(HttpMethod.GET, "/products/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/products").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/products").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/products/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/clients").permitAll()
                        .requestMatchers(HttpMethod.POST, "/clients").permitAll()
                        .requestMatchers(HttpMethod.GET, "/projects").permitAll()
                        .requestMatchers(HttpMethod.POST, "/projects").permitAll()
                        .requestMatchers(HttpMethod.GET, "/productType").permitAll()
                        .requestMatchers(HttpMethod.POST, "/productType").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}