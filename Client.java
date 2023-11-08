import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private BankManager bankManager;

    public Client() {
        initializeRMI();
    }

    private void initializeRMI() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            bankManager = (BankManager) registry.lookup("BankManagerService");
            System.out.println("Connected to server");
            // Initialize GUI with RMI
            SwingUtilities.invokeLater(() -> new BankManagerGUI(bankManager));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error connecting to server: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
