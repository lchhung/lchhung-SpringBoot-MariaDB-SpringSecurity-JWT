package com.lchhung.vehicles.security;

import com.lchhung.vehicles.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*
    @Override
    protected void configure (HttpSecurity http) throws Exception {
    }

    //This is to make In-Memory user name and password
    @Bean
    @Override
    public UserDetailsService userDetailsService (){
        UserDetails user =
                User.withUsername("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    };

 */
    //This is to use user from database
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }



}
