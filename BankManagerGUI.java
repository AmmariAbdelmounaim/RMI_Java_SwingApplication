import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BankManagerGUI {

    private JFrame frame;
    private JTextField txtAccountId;
    private JTextField txtAmount;
    private BankManager bankManager;

    public BankManagerGUI(BankManager bankManager) {
        this.bankManager = bankManager;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the title label
        JLabel lblTitle = new JLabel("Gestion Bancaire", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 20)); // Set font size and style as needed

        // Other components
        JLabel lblAccountId = new JLabel("Compte ID:");
        txtAccountId = new JTextField();
        txtAccountId.setColumns(10);

        JLabel lblAmount = new JLabel("Somme:");
        txtAmount = new JTextField();
        txtAmount.setColumns(10);

        JButton btnCreateAccount = new JButton("Creer Compte");
        btnCreateAccount.addActionListener(this::createAccount);

        JButton btnDeposit = new JButton("Ajouter");
        btnDeposit.addActionListener(this::deposit);

        JButton btnWithdraw = new JButton("Retirer");
        btnWithdraw.addActionListener(this::withdraw);

        JButton btnTransfer = new JButton("Transferer");
        btnTransfer.addActionListener(this::transfer);

        JButton btnCheckBalance = new JButton("Consulter Solde");
        btnCheckBalance.addActionListener(this::checkBalance);

        // Layout for the title
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(lblTitle, BorderLayout.CENTER);

        // Layout for the main components
        JPanel mainPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        mainPanel.add(lblAccountId);
        mainPanel.add(txtAccountId);
        mainPanel.add(lblAmount);
        mainPanel.add(txtAmount);
        mainPanel.add(btnCreateAccount);
        mainPanel.add(btnDeposit);
        mainPanel.add(btnWithdraw);
        mainPanel.add(btnTransfer);
        mainPanel.add(btnCheckBalance);

        // Add title panel at the top and main panel at the center
        frame.setLayout(new BorderLayout());
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createAccount(ActionEvent e) {
        try {
            String id = txtAccountId.getText();
            double amount = Double.parseDouble(txtAmount.getText());
            bankManager.creerCompte(id, amount);
            JOptionPane.showMessageDialog(frame, "Compte créé avec succès !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
        }
    }

    private void deposit(ActionEvent e) {
        try {
            String id = txtAccountId.getText();
            double amount = Double.parseDouble(txtAmount.getText());
            bankManager.ajouter(id, amount);
            JOptionPane.showMessageDialog(frame, "Montant déposé avec succès !");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer un nombre valide pour le montant.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
        }
    }

    private void withdraw(ActionEvent e) {
        try {
            String id = txtAccountId.getText();
            double amount = Double.parseDouble(txtAmount.getText());
            bankManager.retirer(id, amount);
            JOptionPane.showMessageDialog(frame, "Montant retiré avec succès !");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer un nombre valide pour le montant.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
        }
    }

    private void transfer(ActionEvent e) {
        String id_C = JOptionPane.showInputDialog(frame, "Entrez l'identifiant du compte source :");
        String id_D = JOptionPane.showInputDialog(frame, "Entrez l'identifiant du compte de destination:");
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            bankManager.transfererSolde(id_C, id_D, amount);
            JOptionPane.showMessageDialog(frame, "Montant transféré avec succès !");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Veuillez entrer un montant valide.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
        }
    }

    private void checkBalance(ActionEvent e) {
        try {
            String id = txtAccountId.getText();
            double balance = bankManager.consulterSolde(id);
            JOptionPane.showMessageDialog(frame, "Solde: " + balance);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Erreur: " + ex.getMessage());
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
