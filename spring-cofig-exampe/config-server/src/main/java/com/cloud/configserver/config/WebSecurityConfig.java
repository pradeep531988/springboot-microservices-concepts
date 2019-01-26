package com.cloud.configserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .anyRequest().authenticated()
	          //  .and()
	        //.formLogin()
	            .and()
	        .httpBasic(); 
	    http
        .authorizeRequests()
            .anyRequest().authenticated()
            .and()
        .httpBasic();
	}*/
	

	    @Override
	    protected void configure(HttpSecurity http) throws Exception{
	       // http.authorizeRequests().antMatchers("/").permitAll();
	       // http.csrf().disable().authorizeRequests().anyRequest().permitAll();
	        http.authorizeRequests().anyRequest().permitAll();
	    }

}
