package io.pivotal.services.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.pivotal.services.account.Account;

@RestController
public class CreditController {
	
	@Value("${accountSvcUri}")
	private String accountSvcUri;

	private RestTemplate restTemplate;

	@Autowired
	public CreditController(RestTemplate rt) {
		restTemplate = rt;
	}

	@RequestMapping("/iscreditworthy/{accountId}")
	public boolean isCreditWorthy(@PathVariable String accountId) {
		
		String uri = accountSvcUri + "/" + accountId;
		Account account = restTemplate.getForObject(uri, Account.class);
		if (account.getBalance().doubleValue() > 1000) {
			return true;
		}
		
		return false;
	}
	
}
