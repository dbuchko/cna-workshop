package io.pivotal.services.account;

import java.util.List;

public interface AccountService {

		List<Account> listAll();
		Account getById(Long id);
		Account saveOrUpdate(Account account);
		void delete(Long id);
}
