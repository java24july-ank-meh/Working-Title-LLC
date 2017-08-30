package com.tcgtp.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration // creates h2 datasource, hibernate entity manager, and jpa transaction manager
@EntityScan(basePackages = {"com.tcgtp.domain"})
@EnableJpaRepositories(basePackages = {"com.tcgtp.repositories"})
@EnableTransactionManagement
public class RepositoryConfig {
	
}
