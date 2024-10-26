package FinalProject;

import java.util.Scanner;

public class Main {

    private static MaquinaVendas machine;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        machine = MaquinaVendas.loadFromFile();

        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 ->
                    customerMenu();
                case 2 ->
                    adminMenu();
                case 3 -> {
                    machine.saveToFile();
                    System.exit(0);
                }
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("----- Máquina de Venda -----");
        System.out.println("1. Cliente");
        System.out.println("2. Admin");
        System.out.println("3. Exit");
        System.out.print("Seleciona uma opção: ");

    }

    private static void customerMenu() {

        // Show available type of products
        System.out.println("----- Produtos Disponíveis -----");
        System.out.println("1. Chocolate");
        System.out.println("2. Refrigerantes");
        System.out.println("3. Sandes");
        System.out.print("Seleciona uma opção: ");
        int choice = scanner.nextInt();
        // Get the product
        switch (choice) {
            case 1:
                //Get chocolate productos
                System.out.println("----- Chocolate -----");

            case 2:
                //Get refrigerantes productos
                System.out.println("----- Refrigerantes -----");
            case 3:
                //Get sandes productos
                System.out.println("----- Sandes -----");

            default:
                System.out.println("Opção inválida");
        }
    }

    private static void adminMenu() {
        System.out.println("----- Admin Menu -----");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Consultar valor Vendas");
        System.out.println("4. Histórico de produtos vendidos");
        System.out.println("5. Menu anterior");
        System.out.print("Seleciona uma opção: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Adicionar novos produtos a cada uma das categorias. 
                System.out.println("----- Adicionar produto -----");
                System.out.println("1. Chocolate");
                System.out.println("2. Refrigerantes");
                System.out.println("3. Sandes");
                System.out.print("Seleciona uma opção: ");
                int choice2 = scanner.nextInt();
            case 2:
                // - Retirar produtos da máquina.
                System.out.println("----- Remover produto -----");
                System.out.println("1. Chocolate");
                System.out.println("2. Refrigerantes");
                System.out.println("3. Sandes");
                System.out.print("Seleciona uma opção: ");
                int choice3 = scanner.nextInt();

            case 3:
                // - Consultar o valor total resultante de todas as vendas até ao momento.
                System.out.println("----- Consultar valor Vendas -----");
                System.out.println("O valor total é: " + totalVendas);
            case 4:
                // - Visualizar um histórico com todos os produtos vendidos, incluindo o nome do produto e o preço. Este histórico deve poder ser limpo a qualquer momento.
                System.out.println("----- Histórico de produtos vendidos -----");
            case 5:
                // - Voltar ao menu anterior.
                System.out.println("----- Menu anterior -----");
            default:
                System.out.println("Opção inválida");
        }

    }
}
