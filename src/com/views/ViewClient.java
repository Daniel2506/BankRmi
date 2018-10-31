/**
 * 
 */
package com.views;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hola mundo daniel");
		/*ConnectionDB c = new ConnectionDB();
		if (c.connectionDb()) {
			System.out.println("SI");
			if (c.closeDb()) {
				System.out.println("close");
			}
		}else {
			System.out.println("NO");
		}*/
		
		String host = (args.length < 1) ? null : args[0];
        
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            BankInterace stub = (BankInterace) registry.lookup("Bank");
            stub.createAccount("1", "1");
            //String response = Client.menu(stub);
            //String response = stub.getAbs(request);
            //System.out.println("response: " + response);
            //JOptionPane.showMessageDialog(null, "response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}

}
