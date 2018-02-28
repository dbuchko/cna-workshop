package io.pivotal.services.account;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

	List<Account> findByType(String type);
	
}
