package com.dev.ams.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class AmsSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/manifest.json").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/", "/home", "/about").permitAll()
                .antMatchers("/api/v1/admin/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/v1/teacher/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/v1/user/**").hasAnyRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic().authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                String requestedBy = request.getHeader("X-Requested-By");
                System.out.println("X-Requested-By: " + requestedBy);
                if (requestedBy == null || requestedBy.isEmpty()) {
                    HttpServletResponse httpResponse = (HttpServletResponse) response;
                    httpResponse.addHeader("WWW-Authenticate", "realm=Cascade Realm");
                    httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
                } else {
                    HttpServletResponse httpResponse = (HttpServletResponse) response;
                    httpResponse.addHeader("WWW-Authenticate", "Application driven");
                    httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
                }
            }
        });
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());

    }

    //Enable jdbc authentication
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       // auth.jdbcAuthentication().dataSource(dataSource);
        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery("select username, name from users u , role r where u.role_id = r.id and u.username=?")
                .usersByUsernameQuery("select username, password, 1 as enabled from users u  where u.username=?");
    }
}
