package com.interfaces;
/**
 * @author Daniel Tellez Rodriguez
 *
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankInterace extends Remote{
	
	String createAccount(String numAccount, String numClient, String numSucursal) throws RemoteException;
	Boolean deleteAccount(String numAccount) throws RemoteException;
	Boolean editAccount(String numAccount) throws RemoteException;
	Boolean addMoney(String numAccount, String money) throws RemoteException;
	Boolean takeMoney(String numAccount, String money) throws RemoteException;
	Boolean getBalanceMoney(String numAccount) throws RemoteException;
}
