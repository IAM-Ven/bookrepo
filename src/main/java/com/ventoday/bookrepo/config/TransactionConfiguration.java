package com.ventoday.bookrepo.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = {"com.ventoday.bookrepo.repository"})
@EntityScan( basePackages = {"com.ventoday.bookrepo.entity"})
public class TransactionConfiguration {

}



