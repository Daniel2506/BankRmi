package com.entities;
/**
 * @author Daniel Tellez Rodriguez
 *
 */
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String queryInsert = ""
		+ "INSERT INTO uniminuto_cuenta(cuenta_numero, cuenta_valor, cuenta_estado, "
		+ "cuenta_sucursal, cuenta_cliente, cuenta_empleado, cuenta_creacion)"
				+ " VALUES(?,?,?,?,?,?,NOW())";
		if (connect.connectionDb()) {
			
			// System.out.println("Existe conexion");
			// created object account
			Account account = new Account(numAccount, numClient, nameSucursal);
			Connection connection = connect.getConnection();
			try {
			    //Statement statement = connection.createStatement();
		        PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
		        
		        preparedStatement.setString(1, account.getNumAccount());
		        
		        preparedStatement.setObject(2, 0); // Valor
		        preparedStatement.setObject(3, 1); // Estado (0, 1)
		        preparedStatement.setInt(4, 1); // sucursal
		        preparedStatement.setInt(5, 2); // empleado
		        preparedStatement.setInt(6, 1); // empleado
		        //preparedStatement.setObject(7, "NOW()");
		        preparedStatement.executeUpdate();
		        
		        msg =  "Cuenta creada exitosamente.";
			} catch (Exception e) {
				System.out.println(e);
				msg = e.getMessage();
			}
		}
		//System.out.println("HOLA createAccount");
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
	public String addMoney(String numAccount, String money) throws RemoteException {
		// TODO Auto-generated method stub
		String msg = "" ;
		String queryUpdate = "UPDATE uniminuto_cuenta SET cuenta_valor = ? WHERE cuenta_numero = ?";
		
	if (connect.connectionDb()) {	
			Account account = new Account(numAccount, Double.parseDouble(money));
			Connection connection = connect.getConnection();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
		        
				preparedStatement.setObject(1, account.getMoney());
				preparedStatement.setString(2, account.getNumAccount());
		        preparedStatement.executeUpdate();
		        
		        msg =  "Consignacion exitosamente.";
			} catch (Exception e) {
				System.out.println(e);
				msg = e.getMessage();
			}
		}
		return msg;
	}

	@Override
	public String takeMoney(String numAccount, String money) throws RemoteException {
		// TODO Auto-generated method stub
		String msg = "";
		String querySelect = "SELECT * FROM uniminuto_cuenta WHERE cuenta_numero = " + numAccount;
		String queryUpdate = "UPDATE uniminuto_cuenta SET cuenta_valor = ? WHERE cuenta_numero = ?";
		if (connect.connectionDb()) {	
			Account account = new Account();
			Double  retiro = 0.0;
			
			try {
				ResultSet rs = connect.consult(querySelect);
				//System.out.println (rs.getDouble("cuenta_valor"));
				while(rs.next()) {
					account.setNumAccount(rs.getString("cuenta_numero"));
					account.setMoney(rs.getDouble("cuenta_valor"));
				}
				
				
				retiro = account.getMoney() - Double.parseDouble(money);
				
				if(retiro < 0 ) {
					msg = "Error 1";
					return msg ;
				}
				account.setMoney(retiro);
				
				Connection connection = connect.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
				preparedStatement.setObject(1, account.getMoney());
				preparedStatement.setString(2, account.getNumAccount());
		        preparedStatement.executeUpdate();
		        
		        msg =  "OK 5";
			} catch (Exception e) {
				System.out.println(e);
				msg = e.getMessage();
			}
		}
		return msg;
	}

	@Override
	public Boolean getBalanceMoney(String numAccount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
