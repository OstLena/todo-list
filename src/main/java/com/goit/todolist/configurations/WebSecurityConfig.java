package com.goit.todolist.configurations;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .passwordEncoder(new PasswordEncoder() {
////                    @Override
////                    public String encode(CharSequence rawPassword) {
////                        return rawPassword.toString();
////                    }
//
//                    @Override
//                    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                        return rawPassword.toString().equals(encodedPassword);
//                    }
//                })

                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from user_table where username=?")
                .authoritiesByUsernameQuery("select username, role from user_table where username=?")
        ;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll()
                        .defaultSuccessUrl("/note/list", true))
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }
}
