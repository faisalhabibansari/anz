package com.wholesale.anz.api;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.wholesale.anz.api.config.ApplicationProperties;
import com.wholesale.anz.api.entities.Account;
import com.wholesale.anz.api.entities.AccountTransaction;
import com.wholesale.anz.api.repositories.AccountRepository;
import com.wholesale.anz.api.repositories.AccountTransactionRepository;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class Application {

	// Application Start
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    // Seeding Information Of Account And AccountTransaction
	@Bean
	@Profile("local")
	CommandLineRunner initDatabase(AccountRepository accountsRepository, AccountTransactionRepository accountsTransactionsRepository){
		return args -> {
			accountsRepository.saveAll(
					Arrays.asList(
					new Account(
							 1L,
							"5465875120",
							"SGSavings726",
							"Savings",
							 new Date(),
							"SGD",
							"84,327.51"
					),
					new Account(
							 2L,
							"7845976812",
							"AUSavings933",
							"Savings",
							 new Date(),
							"AUD",
							"88,005.93"
					),
					new Account(
							 3L,
							"3211430489",
							"AUCurrent433",
							"Current",
							 new Date(),
							"AUD",
							"88,005.93"
					)
				)
			);
			
			
			accountsTransactionsRepository.saveAll(
					Arrays.asList(
					new AccountTransaction(
							 1L,
							"5465875120",
							"SGSavings726",
							 new Date(),
							"SGD",
							0.0,
							84327.51,
							"Credit",
							"Personal"
					),
					new AccountTransaction(
							 2L,
							"5465875120",
							"SGSavings726",
							 new Date(),
							"SGD",
							0.0,
							52000.41,
							"Credit",
							"Borrowed"
					),
					new AccountTransaction(
							 3L,
							"5465875120",
							"SGSavings726",
							 new Date(),
							"SGD",
							5000.0,
							0.0,
							"Debit",
							"Used"
					),
					new AccountTransaction(
							 4L,
							"7845976812",
							"AUSavings933",
							 new Date(),
							"AUD",
							0.0,
							25435.0,
							"Credit",
							"Personal"
					),
					new AccountTransaction(
							 5L,
							"7845976812",
							"AUSavings933",
							 new Date(),
							"AUD",
							0.0,
							49758.45,
							"Credit",
							"Personal"
					),
					new AccountTransaction(
							 6L,
							"3211430489",
							"AUCurrent433",
							 new Date(),
							"AUD",
							0.0,
							47035.0,
							"Credit",
							""
					)
				)
			);
					
			};
	}
}
