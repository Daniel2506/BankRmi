package com.entities;
/**
 * @author Daniel Tellez Rodriguez
 *
 */
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.connections.ConnectionDB;
import com.connections.Daos;
import com.interfaces.BankInterace;

public class Client extends Person implements BankInterace{
	
	private int idClient;
	private ConnectionDB connect;
	
	public Client() {
		super();
		this.connect = new ConnectionDB();
		//this.connect.connectionDb();
	}

	/*
	* Methods Get and Setters 
	*/
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	@Override
	public String createAccount(String numAccount, String numClient, String nameSucursal) throws RemoteException {
		// TODO Auto-generated method stub
		
		String msg = "" ;
		String queryInsert = "INSERT INTO uniminuto_account(cuenta_numero, cuenta_creacion, cuenta_valor, cuenta_estado, cuenta_sucursal, cuenta_empleado)"
				+ " VALUES(?,?,?,?,NOW())";
		if (connect.connectionDb()) {
			
			// System.out.println("Existe conexion");
			// created object account
			Account account = new Account(numAccount, numClient, nameSucursal);
			Connection connection = connect.getConnection();
			try {
			    Statement statement = connection.createStatement();
		        PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("HOLA createAccount");
		return msg;
	}

	@Override
	public Boolean deleteAccount(String numAccount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean editAccount(String numAccount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addMoney(String numAccount, String money) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean takeMoney(String numAccount, String money) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getBalanceMoney(String numAccount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
