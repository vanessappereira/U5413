package FinalProject;

import java.util.List;
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
        System.out.println("\n----- Máquina de Venda -----");
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
        System.out.println("\nInsira o dinheiro: ");
        try {
            double money = Double.parseDouble(scanner.nextLine());
            System.out.println("\nSelecione o tipo de produto:");
            System.out.println("1. Chocolate");
            System.out.println("2. Refrigerante");
            System.out.println("3. Sandes");

            int choice = Integer.parseInt(scanner.nextLine());
            String categoria = switch (choice) {
                case 1 ->
                    "chocolate";
                case 2 ->
                    "refrigerante";
                case 3 ->
                    "sandes";
                default ->
                    "";
            };

            List<Produto> produtos = machine.listarProdutosDisponiveis(categoria);
            if (produtos.isEmpty()) {
                System.out.println("Não há produtos disponíveis nesta categoria!");
                return;
            }

            // Display available products
            produtos.forEach(p -> System.out.println(
                    p.getreferencia() + " - " + p.getnome() + " - " + p.getpreco() + "€"));

            System.out.println("\nInsira a referência do produto:");
            String ref = scanner.nextLine();
            Result result = machine.venderProduto(ref, money);

            System.out.println(result.getMessage());
            if (result.isSuccess() && result.getTroco() > 0) {
                System.out.printf("Seu troco: %.2f€%n", result.getTroco());
            }

        } catch (NumberFormatException e) {
            System.out.println("Valor inválido inserido!");
        }
    }

    private static void adminMenu() {
        System.out.println("\nSelecione a opção:");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Consultar valor total de vendas");
        System.out.println("4. Visualizar Histórico");
        System.out.println("5. Voltar ao menu principal");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 ->
                adicionarProduto(machine);
            case 2 ->
                removerProduto(machine);
            case 3 ->
                System.out.println(machine.getTotalVendas());
            case 4 ->
                System.out.println(machine.getProdutosVendidos());
            case 5 ->
                showMainMenu();
            default ->
                System.out.println("Opção inválida!");
        }
    }
}
