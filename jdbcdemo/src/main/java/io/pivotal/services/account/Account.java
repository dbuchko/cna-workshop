package io.pivotal.services.account;

import java.math.BigDecimal;

public class Account {

	private Long id;
	private String type;
	private String status;
	private BigDecimal balance;
	
	protected Account() {
		
	}
	
	public Account(String type, String status, double balance) {
		super();
		this.id = java.util.UUID.randomUUID().getLeastSignificantBits();
		this.type = type;
		this.status = status;
		this.balance = BigDecimal.valueOf(balance);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return ("ID:" + String.valueOf(id) + 
				", type: " + type +
				", status: " + status +
				", balance: " + balance);
	}
}
