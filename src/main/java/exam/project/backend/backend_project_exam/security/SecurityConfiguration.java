package exam.project.backend.backend_project_exam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    @SuppressWarnings("removal")
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                // .requestMatchers(HttpMethod.POST, "/games/create").hasAuthority("ADMIN")
                // .requestMatchers(HttpMethod.POST, "/games/edit/**").hasAuthority("ADMIN")
                // .requestMatchers(HttpMethod.POST, "/games/delete/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/games/create").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/games/edit/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST).hasAnyAuthority("ADMIN")
                .requestMatchers("/games/**").permitAll()
                .requestMatchers("/**").permitAll()
                .requestMatchers("/api/**").permitAll()
                .and().formLogin().loginPage("/login")
                .and().logout().logoutSuccessUrl("/")
                .and().exceptionHandling()
                .and().csrf().disable();

        return http.build();
    }

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailService());

        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    DatabaseUserDetailService userDetailService() {
        return new DatabaseUserDetailService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    
}
