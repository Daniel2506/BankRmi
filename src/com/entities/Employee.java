package com.entities;
/**
 * @author Daniel Tellez Rodriguez
 *
 */
import java.rmi.RemoteException;

import com.interfaces.BankInterace;

public class Employee extends Person implements BankInterace{
	
	private int idEmployee;
	
	public Employee() {
		super();
	}
	
	/*
	* Methods Get and Setters 
	*/
	
	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	/* (non-Javadoc)
	 * @see com.interfaces.BankInterace#createAccount(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String createAccount(String numAccount, String numClient, String numSucursal) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.interfaces.BankInterace#deleteAccount(java.lang.String)
	 */
	@Override
	public Boolean deleteAccount(String numAccount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.interfaces.BankInterace#editAccount(java.lang.String)
	 */
	@Override
	public Boolean editAccount(String numAccount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.interfaces.BankInterace#addMoney(java.lang.String, java.lang.String)
	 */
	@Override
	public String addMoney(String numAccount, String money) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.interfaces.BankInterace#takeMoney(java.lang.String, java.lang.String)
	 */
	@Override
	public String takeMoney(String numAccount, String money) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.interfaces.BankInterace#getBalanceMoney(java.lang.String)
	 */
	@Override
	public Boolean getBalanceMoney(String numAccount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
