package ru.netology.hibernate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Конфигурация security
 *
 * @author Viktor_Loskutov
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().and()
                .authorizeHttpRequests().antMatchers("/persons/get/*").permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().hasRole("admin");
    }
}