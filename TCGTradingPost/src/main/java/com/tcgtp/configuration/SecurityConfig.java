package com.tcgtp.configuration;

import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder(StrongPasswordEncryptor passwordEncryptor) {
		PasswordEncoder encoder = new PasswordEncoder();
		encoder.setPasswordEncryptor(passwordEncryptor);
		return encoder;
	}
	
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setPasswordEncoder(passwordEncoder);
		daoAuthProvider.setUserDetailsService(userDetailsService);
		return daoAuthProvider;
	}
	
	private AuthenticationProvider authenticationProvider;
	@Autowired
	@Qualifier(value="daoAuthenticationProvider")
	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}
	
	@Autowired
	public void configureAuthenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) {
		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
	}
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        		.authorizeRequests().antMatchers("/", "/home", "/cardSearch")
        		.permitAll().anyRequest().authenticated()
        	.and()
        		.formLogin().loginPage("/Login").permitAll()
        	.and()
        		.logout().permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
