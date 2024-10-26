package FinalProject;

import java.util.Scanner;

public class Main {

    private static MaquinaVendas machine;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        machine = MaquinaVendas.loadFromFile();
        try {
            while (true) {
                showMainMenu();
            }
        } finally {
            try (scanner) {
                machine.saveToFile();
            }
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
                case 3 ->
                    System.exit(0);
                default ->
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido!");
        }
    }

    private static void customerMenu() {
        
    }

    private static void adminMenu() {
        System.out.println("\nSelecione a opção:");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Consultar valor total de vendas");
        System.out.println("4. Visualizar Histórico");
        System.out.println("5. Voltar ao menu principal");
        
    }
}
