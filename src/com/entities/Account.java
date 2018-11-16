package com.entities;
/**
 * @author Daniel Tellez Rodriguez
 *
 */
public class Account {
	
	private String numAccount;
	private Double money;
	private Double balance;
	private Office officeAcount;
	private Client clientAcount;
	
	public Account() {}
	
	public Account(String numAccount) {
		this.numAccount = numAccount;
	}
	
	public Account (String numAccount, String numClient, String name) {
		this.numAccount = numAccount;
		this.money = 0.0;
		this.balance = 0.0;
		this.officeAcount = Office.getOffice(name);
	}
	
	public Account(String numAccount, double money) {
		this.numAccount = numAccount;
		this.money = money;
	}

	public String getNumAccount() {
		return numAccount;
	}

	public void setNumAccount(String numAccount) {
		this.numAccount = numAccount;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Office getOfficeAcount() {
		return officeAcount;
	}

	public void setOfficeAcount(Office officeAcount) {
		this.officeAcount = officeAcount;
	}

	public Client getClientAcount() {
		return clientAcount;
	}

	public void setClientAcount(Client clientAcount) {
		this.clientAcount = clientAcount;
	}
	
	
}
