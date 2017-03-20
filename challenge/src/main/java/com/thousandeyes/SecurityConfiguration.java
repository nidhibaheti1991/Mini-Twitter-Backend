package com.thousandeyes;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("secret1").roles("USER")
                .and()
                .withUser("user2").password("secret2").roles("USER")
                .and()
                .withUser("user3").password("secret3").roles("USER")
                .and()
                .withUser("user4").password("secret4").roles("USER")
                .and()
                .withUser("user5").password("secret5").roles("USER")
                .and()
                .withUser("user6").password("secret6").roles("USER")
                .and()
                .withUser("user7").password("secret7").roles("USER")
                .and()
                .withUser("user8").password("secret8").roles("USER")
                .and()
                .withUser("user9").password("secret9").roles("USER")
                 .and()
                .withUser("user10").password("secret10").roles("USER");





    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/h2-console/*","/test","/person","/followers","/following","/follow","/unfollow","/messages").permitAll().anyRequest().authenticated();
//
//
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated();
        http.httpBasic();
        http.csrf().disable();
    }

}