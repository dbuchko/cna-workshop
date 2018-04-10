package io.pivotal.services.account;

import java.util.List;

public interface AccountService {

	public List<Account> listAll();
	public Account getById(Long id);
	public Account saveOrUpdate(Account account);
	public void delete(Long id);
}
