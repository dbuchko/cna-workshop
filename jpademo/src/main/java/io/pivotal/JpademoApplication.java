package io.pivotal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.pivotal.services.account.Account;
import io.pivotal.services.account.AccountRepository;

@SpringBootApplication
public class JpademoApplication {

	private static final Logger log = LoggerFactory.getLogger(JpademoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AccountRepository repository) {
		
		final String STATUS_ACTIVE = "Active";
		final String STATUS_CLOSED = "Closed";

		final String TYPE_CHEQUING = "Chequing";
		final String TYPE_SAVINGS = "Savings";

		return (args) -> {
			// save a couple of accounts
			repository.save(new Account(TYPE_CHEQUING, STATUS_ACTIVE, 2446));
			repository.save(new Account(TYPE_CHEQUING, STATUS_ACTIVE, 5433));
			repository.save(new Account(TYPE_CHEQUING, STATUS_CLOSED, 0));
			repository.save(new Account(TYPE_SAVINGS, STATUS_ACTIVE, 845));

			// fetch all customers
			log.info("Accounts found with findAll():");
			log.info("-------------------------------");
			for (Account customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual account by ID
			Account account = repository.findOne(1L);
			log.info("Account found with findOne(1L):");
			log.info("--------------------------------");
			log.info(account.toString());
			log.info("");

			// fetch accounts by type
			log.info("Account found with findByType('Chequing'):");
			log.info("---------------------------------------");
			for (Account active : repository.findByType(TYPE_CHEQUING)) {
				log.info(active.toString());
			}
			log.info("");
		};
	}

}
