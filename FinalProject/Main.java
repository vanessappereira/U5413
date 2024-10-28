package FinalProject;

import java.util.Scanner;

public class Main {

    private static VendingMachine machine;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        machine = VendingMachine.loadFromFile();
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("----- Máquina de Venda -----");
            System.out.println("--- 1. Cliente           ---");
            System.out.println("--- 2. Admin             ---");
            System.out.println("--- 3. Sair              ---");
            System.out.print("Selecione uma opção: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->
                    customerMenu();
                case 2 ->
                    adminMenu();
                case 3 -> {
                    exitProgram();
                }
                default ->
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void customerMenu() {
        System.out.println("------- Menu Cliente -------");
        System.out.println("1. Comprar produto");
        System.out.println("2. Voltar ao menu principal");
        System.out.print("Selecione uma opção: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 ->
                machine.buyProduct(scanner);
            case 2 ->
                showMainMenu();
            default ->
                System.out.println("Opção inválida!");
        }
    }

    private static void adminMenu() {
        System.out.println("----- Menu Admin -----\n");
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
                    machine.displaySalesHistory();
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

    private static void exitProgram() {
        System.out.println("Obrigado por usar a Máquina de Venda!");
        machine.saveToFile(); // Save the state before exiting
        System.exit(0);
    }
}
