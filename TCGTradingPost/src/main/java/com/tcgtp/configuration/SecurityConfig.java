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
<<<<<<< HEAD
=======
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
>>>>>>> master

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder(StrongPasswordEncryptor passwordEncryptor) {
		PasswordEncoder encoder = new PasswordEncoder();
		encoder.setPasswordEncryptor(passwordEncryptor);
		return encoder;
	}
	
	
	@Bean
<<<<<<< HEAD
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
=======
    public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
                                                               UserDetailsService userDetailsService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
	}
	
	private AuthenticationProvider authenticationProvider;

    @Autowired
    @Qualifier("daoAuthenticationProvider")
    public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
>>>>>>> master
	
	@Autowired
	public void configureAuthenticationManager(AuthenticationManagerBuilder authenticationManagerBuilder) {
		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
	}
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
<<<<<<< HEAD
        		.authorizeRequests().antMatchers("/", "/home", "/cardSearch", "/console/**")
=======
        		.authorizeRequests().antMatchers("/", "/home", "/cardSearch", "/console/**", "/cardSearcher")
>>>>>>> master
        		.permitAll().anyRequest().authenticated()
        	.and()
        		.formLogin().loginPage("/login").permitAll()
        	.and()
        		.logout().permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
