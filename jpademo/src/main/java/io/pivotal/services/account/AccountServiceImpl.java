package io.pivotal.services.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> listAll() {
		List<Account> accounts = new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);
		return accounts;
	}

	@Override
	public Account getById(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	public Account saveOrUpdate(Account account) {
		Account savedAccount = accountRepository.save(account);
		return savedAccount;
	}

	@Override
	public void delete(Long id) {
		accountRepository.delete(id);

	}

}
