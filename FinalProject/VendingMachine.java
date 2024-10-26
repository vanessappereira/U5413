package FinalProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine implements Serializable {

    private static final int MAX_CHOCOLATES = 20;
    private static final int MAX_REFRIGERANTES = 15;
    private static final int MAX_SANDES = 10;

    private List<Chocolate> chocolates;
    private List<Refrigerante> refrigerantes;
    private List<Sandes> sandwiches;
    private List<Produto> produtosVendidos;
    private double totalVendas;

    public VendingMachine() {
        chocolates = new ArrayList<>();
        refrigerantes = new ArrayList<>();
        sandwiches = new ArrayList<>();
        produtosVendidos = new ArrayList<>();
        totalVendas = 0.0;
    }

    static VendingMachine loadFromFile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /* Machine management 
  * Add Product using scanner */
    public void addProduct(Scanner scanner) {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1 - Chocolate");
        System.out.println("2 - Refrigerante");
        System.out.println("3 - Sandes");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        switch (choice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                System.out.println("Opção inválida!");
        }

    }

    public List<Produto> getSoldProducts() {
        return new ArrayList<>(produtosVendidos);
    }

    public double getTotalSales() {
        return totalVendas;
    }

    public void cleanHistorySales() {
        produtosVendidos.clear();
        totalVendas = 0.0;
    }

    /* Client Menu */
 /* Buy Product */
    public void buyProduct(Scanner scanner) {

        System.out.println("Escolha o produto:");
        System.out.println("1 - Chocolate");
        System.out.println("2 - Refrigerante");
        System.out.println("3 - Sandes");
        System.out.println("4 - Sair");

        /* First select the type of product */
        int choice = scanner.nextInt();
        scanner.nextLine();

        /* List all type products */
        switch (choice) {
            case 1:
                /* Choose a product by reference */
                System.out.println("Escolha o chocolate:");

                // Call the readStock() method from the Chocolate class
                List<Chocolate> chocolates = Chocolate.readStock(); // Ensure Chocolate class is accessible
                for (int i = 0; i < chocolates.size(); i++) {
                    System.out.println((i + 1) + " - " + chocolates.get(i).getNome());
                }

                System.out.println("5 - Sair");
                break; // Don't forget to add a break statement

            case 2:
                // List Refrigerantes
                /* Choose a product by reference */

                System.out.println("Escolha o refrigerante:");

            case 3:
                // List Sandes
                /* Choose a product by reference */
                System.out.println("Escolha a sandes:");

            case 4:
                System.out.println("Voltando ao menu principal.");
                break;
        }

        /* Add amount */
 /* Use Result */
    }
}
