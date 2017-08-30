package com.tcgtp.configuration;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfig {

	// Creates bean for password encryptor
	@Bean
	public StrongPasswordEncryptor passwordEncryptor() {
		return new StrongPasswordEncryptor();
	}
}
