/**
 * 
 */
package com.views;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import com.connections.ConnectionDB;
import com.interfaces.BankInterace;

/**
 * @author Daniel Tellez Rodriguez
 *
 */
public class ViewClient {

	
public static String menu (BankInterace stub) throws RemoteException {
		
		String menu = "Bienvenido! \n Escoja un número de menú \n 1. Crear Cuenta"
					+ "\n 2. Consignar \n  3. Retirar \n 0. Salir";
		String item = JOptionPane.showInputDialog(menu);
		
		String data1 = null;
		String data2 = null;
		String data3 = null;
		
		String response = null;
		switch (item) {
		case "1":
			data1 = JOptionPane.showInputDialog("Ingrese Número:");
			data2 = JOptionPane.showInputDialog("Ingrese Identificación del Cliente:");
			data3 = JOptionPane.showInputDialog("Ingrese Nombre de sucursal:");
			response = stub.createAccount(data1, data2, data3);
			break;
		case "2":
			data1 = JOptionPane.showInputDialog("Ingrese Número:");
			data2 = JOptionPane.showInputDialog("Ingrese Identificación del Cliente:");
			response = stub.addMoney(data1, data2);
			break;
		case "3":
			data1 = JOptionPane.showInputDialog("Ingrese Número Cuenta:");
			data2 = JOptionPane.showInputDialog("Ingrese Valor a retirar:");
			response = stub.takeMoney(data1, data2);
			break;
		case "0":
			System.exit(0);
			break;
		default:
			JOptionPane.showInternalMessageDialog(null, "Menú no valido");
			menu(stub);
			break;
		}
		return response;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = (args.length < 1) ? null : args[0];
        
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            BankInterace stub = (BankInterace) registry.lookup("Bank");
            String response = ViewClient.menu(stub);
            JOptionPane.showMessageDialog(null, "response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}

}
