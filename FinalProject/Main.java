package FinalProject;

import java.util.Scanner;

public class Main {

    private static VendingMachine machine;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        machine = VendingMachine.loadFromFile();

        while (true) {
            showMainMenu();
        }
    }

    private static void showMainMenu() {
        System.out.println("----- Máquina de Venda -----");
        System.out.println("1. Cliente");
        System.out.println("2. Admin");
        System.out.println("3. Sair");
        System.out.print("Selecione uma opção: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->
                    customerMenu();
                case 2 ->
                    adminMenu();
                case 3 -> {
                    machine.saveToFile();
                    System.out.println("Thank you for using the Vending Machine. Goodbye!");
                    System.exit(0);
                }
                default ->
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido!");
        }
    }

    private static void customerMenu() {
        System.out.println("----- Menu Cliente -----");
        machine.buyProduct(scanner);
    }

    private static void adminMenu() {
        System.out.println("\nSelecione a opção:");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Consultar valor total de vendas");
        System.out.println("4. Visualizar Histórico");
        System.out.println("5. Limpar Histórico");
        System.out.println("6. Voltar ao menu principal");
        System.out.print("Selecione uma opção: ");
        try {
            int adminChoice = Integer.parseInt(scanner.nextLine());
            switch (adminChoice) {
                case 1 -> {
                    machine.addProduct(scanner);
                    machine.saveToFile();
                }
                case 2 -> {
                    // Implement remove product
                    machine.saveToFile();
                }
                case 3 -> {
                    machine.saveToFile();
                    System.out.println("Valor total de vendas: " + machine.getTotalSales());
                }
                case 4 -> {
                    machine.saveToFile();
                    machine.getSoldProducts();
                }
                case 5 -> {
                    machine.saveToFile();
                    machine.cleanHistorySales();
                }
                case 6 ->
                    showMainMenu();
                default ->
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido!");
        }
    }
}
