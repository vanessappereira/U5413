package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class VendingMachineGUI extends JFrame {
    private JTextArea displayArea;
    private VendingMachine vendingMachine;

    public VendingMachineGUI() {
        // Initialize VendingMachine
        vendingMachine = new VendingMachine();

        // Set up the frame
        setTitle("Vending Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create display area
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea)); // Add scroll pane for the text area

        // Create buttons for menu options
        JButton clientButton = new JButton("Cliente");
        JButton adminButton = new JButton("Admin");
        JButton exitButton = new JButton("Sair");

        // Add action listeners for buttons
        clientButton.addActionListener(e -> handleClientMenu());
        adminButton.addActionListener(e -> handleAdminMenu());
        exitButton.addActionListener(e -> System.exit(0));

        // Add buttons to the frame
        add(clientButton);
        add(adminButton);
        add(exitButton);

        // Display the main menu
        displayMainMenu();

        setVisible(true);
    }

    // Method to display the main menu
    private void displayMainMenu() {
        String menu = vendingMachine.showMainMenuGUI(null, vendingMachine); // Pass null for Scanner
        displayArea.setText(menu); // Display the menu in the text area
    }

    private void handleClientMenu() {
        // Logic for handling client menu
        displayArea.append("Client menu selected.\n");
    }

    private void handleAdminMenu() {
        // Logic for handling admin menu
        displayArea.append("Admin menu selected.\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VendingMachineGUI());
    }
}