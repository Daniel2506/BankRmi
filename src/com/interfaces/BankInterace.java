package com.interfaces;
/**
 * @author Daniel Tellez Rodriguez
 *
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankInterace extends Remote{
	
	String createAccount(String numAccount, String numClient, String numSucursal) throws RemoteException;
	String deleteAccount(String numAccount) throws RemoteException;
	String editAccount(String numAccount) throws RemoteException;
	String addMoney(String numAccount, String money) throws RemoteException;
	String takeMoney(String numAccount, String money) throws RemoteException;
	String getBalanceMoney(String numAccount) throws RemoteException;
}
