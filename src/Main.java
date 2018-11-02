import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import com.entities.Client;
import com.interfaces.BankInterace;

/**
 * @author Daniel Tellez Rodriguez
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            Client obj = new Client();
            BankInterace stub = (BankInterace) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Bank", stub);
            

            System.err.println("Server ready");
            
            //stub.createAccount("1", "1", "1");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}

}
