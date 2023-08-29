package dev.unscrud.mudi;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Autowired
    private DataSource dataSource;
    
    /**
     * Foi necessário o uso do MvcRequestMatcher ao utilizar as versões 20 do java
     * 3.1.2 do Spring Boot e 6.1.2 do Spring Security, sendo necessário o uso da
     * solução encontrada nos seguintes links: 
     * 
     * https://stackoverflow.com/questions/76809698/spring-security-method-cannot-decide-pattern-is-mvc-or-not-spring-boot-applicati
     * https://spring.io/security/cve-2023-34035
     * https://github.com/spring-projects/spring-security-samples/commit/4e3bec904a5467db28ea33e25ac9d90524b53d66
     * https://spring.io/guides/gs/securing-web/
     * 
     * @param http
     * @param mvc
     * @return
     * @throws Exception 
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, 
            MvcRequestMatcher.Builder mvc) throws Exception {
        http.authorizeHttpRequests((requests) ->  requests
            .requestMatchers(
                    mvc.pattern("/hello"),
                    mvc.pattern("/home")
            ).permitAll()
            .anyRequest().authenticated()            
        ).formLogin((form)-> form
            .loginPage("/login")
            .defaultSuccessUrl("/usuario/pedido",true)
            .permitAll()
        ).logout((logout) -> logout.logoutUrl("/logout"));
        
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
            .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Scope("prototype")
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    UserDetailsManager users(DataSource dataSource){
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("pwd"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("pwd"))
                .roles("USER", "ADMIN")
                .build();
        
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        
        if (!users.userExists(user.getUsername())){
            users.createUser(user);
        }
        if (!users.userExists(admin.getUsername())){
            users.createUser(admin);
        }

        return users;
    }
}
