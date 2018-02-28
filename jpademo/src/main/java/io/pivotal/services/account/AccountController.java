package io.pivotal.services.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private AccountService accountService;
	
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping("/accounts")
	public List<Account> getAccountList() {
		return accountService.listAll();
	}
	
	@RequestMapping("/account/{id}")
	public Account getAccount(@PathVariable String id) {
		return accountService.getById(Long.valueOf(id));
	}
	
	@RequestMapping(value="/account/{id}", method=RequestMethod.DELETE)
	public void deleteAccount(@PathVariable String id) {
		accountService.delete(Long.valueOf(id));
		return;
	}

	@RequestMapping(value="/account", method=RequestMethod.POST)
	public Long createAccount(Account account) {
		return accountService.saveOrUpdate(account).getId();
	}
}
