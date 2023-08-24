package dev.unscrud.mudi;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
            try {
                requests
                        .anyRequest().authenticated()
                        .and().httpBasic();
            } catch (Exception ex) {
                Logger.getLogger(WebSecurityConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                );
        
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
           User.withDefaultPasswordEncoder()
                  .username("user")
                  .password("password")
                  .roles("USER")
                  .build();

        return new InMemoryUserDetailsManager(user);
    }    
}
