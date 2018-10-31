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
}
