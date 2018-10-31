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
	
	public Account (String numAccount, String numClient, String name) {
		this.numAccount = numAccount;
		this.money = 0.0;
		this.balance = 0.0;
		this.officeAcount.getOffice(name);
	}
}
