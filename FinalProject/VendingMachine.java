package FinalProject;

import FinalProject.Chocolate.TipoCacau;
import FinalProject.Refrigerante.TipoRefri;
import FinalProject.Sandes.TipoSandes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine implements Serializable {

    private static final int MAX_CHOCOLATES = 20;
    private static final int MAX_REFRIGERANTES = 15;
    private static final int MAX_SANDES = 10;

    private final List<Chocolate> chocolates;
    private final List<Refrigerante> refrigerantes;
    private final List<Sandes> sandwiches;
    private final List<Produto> produtosVendidos;
    private double totalVendas;

    public VendingMachine() {
        chocolates = new ArrayList<>();
        refrigerantes = new ArrayList<>();
        sandwiches = new ArrayList<>();
        produtosVendidos = new ArrayList<>();
        totalVendas = 0.0;
    }

    public static VendingMachine loadFromFile() {
        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream("stock.dat"))) {
            return (VendingMachine) file.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading vending machine: " + e.getMessage());
            return new VendingMachine();
        }
    }

    public void saveToFile() { //Implement in functions
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stock.dat"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Erro a guardar no ficheiro da máquina: " + e.getMessage());
        }
    }

    /* Machine management - Add Product using scanner */
    public void addProduct(Scanner scanner) {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1 - Chocolate");
        System.out.println("2 - Refrigerante");
        System.out.println("3 - Sandes");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (choice) {
            case 1 ->
                addChocolate(scanner);
            case 2 ->
                addRefrigerante(scanner);
            case 3 ->
                addSandes(scanner);
            default ->
                System.out.println("Opção inválida!");
        }
    }

    private void addChocolate(Scanner scanner) {
        scanner.nextLine(); // Consume newline left-over
        TipoCacau tipoCacau;

        if (chocolates.size() >= MAX_CHOCOLATES) {
            System.out.println("Máximo de chocolates atingido!");
        } else {
            System.out.println("Introduza a quantidade de chocolate a adicionar:");
            int quantity = scanner.nextInt();

            scanner.nextLine(); // Consume newline left-over
            // Verify if its possible to add the quantity
            if (quantity > MAX_CHOCOLATES - chocolates.size()) {
                System.out.println("Não é possível adicionar essa quantidade!");
            } else {
                System.out.println("Introduza o nome do chocolate:");
                String name = scanner.nextLine();

                System.out.println("Introduza o preço:");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over 

                System.out.println("Introduza a data de validade (dd/mm/yyyy):");
                String expDate = scanner.nextLine();

                System.out.println("Introduza a referência do chocolate: ");
                String reference = scanner.nextLine();

                System.out.println("Introduza a marca do chocolate: ");
                String brand = scanner.nextLine();

                System.out.print("1 - Branco\n2 - Leite\n3 - Negro\nSelecione o tipo de cacau do chocolate: ");

                int cocoaType = scanner.nextInt();
                switch (cocoaType) {
                    case 1 -> {
                        tipoCacau = TipoCacau.BRANCO;
                    }
                    case 2 -> {
                        tipoCacau = TipoCacau.LEITE;
                    }
                    case 3 -> {
                        tipoCacau = TipoCacau.NEGRO;
                    }
                    default -> {
                        System.out.println("Tipo de cacau inválido!");
                        return;
                    }
                }
                System.out.println("Selecionado: " + tipoCacau);
                for (int i = 0; i < quantity; i++) {
                    Chocolate chocolate = new Chocolate(name, price, expDate, reference, brand, tipoCacau);

                    chocolates.add(chocolate);
                    System.out.println("Chocolate adicionado com sucesso!");
                }
            }
        }
    }

    private void addRefrigerante(Scanner scanner) {
        scanner.nextLine();
        TipoRefri tipoRefri;

        if (refrigerantes.size() <= MAX_REFRIGERANTES) {
            System.out.println("Máximo de refrigerantes atingido!");
        } else {
            System.out.println("Introduza a quantidade de refrigerantes a adicionar:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            // Verify if its possible to add the quantity
            if (quantity > MAX_REFRIGERANTES - refrigerantes.size()) {
                System.out.println("Não é possível adicionar essa quantidade!");
            } else {
                System.out.println("Introduza o nome do refrigerante:");
                String name = scanner.nextLine();

                System.out.println("Introduza o preço:");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over 

                System.out.println("Introduza a data de validade (dd/mm/yyyy):");
                String expDate = scanner.nextLine();

                System.out.println("Introduza a referência: ");
                String reference = scanner.nextLine();

                System.out.println("Introduza a marca do refrigerante: ");
                String brand = scanner.nextLine();

                System.out.println("Introduza o tipo de refrigerante\n1 - Normal\n2 - Sem Açúcar:");
                int refrigeranteType = scanner.nextInt();

                scanner.nextLine(); // Consume newline left-over
                switch (refrigeranteType) {
                    case 1 -> {
                        tipoRefri = TipoRefri.NORMAL;
                    }
                    case 2 -> {
                        tipoRefri = TipoRefri.SUGARFREE;
                    }
                    default -> {
                        System.out.println("Tipo de refrigerante inválido!");
                        return;
                    }
                }
                System.out.println("Selecionado: " + tipoRefri);

                for (int i = 0; i < quantity; i++) {
                    Refrigerante refrigerante = new Refrigerante(name, price, expDate, reference, brand, tipoRefri);
                    refrigerantes.add(refrigerante);
                    System.out.println("Refrigerante adicionado com sucesso!");
                }

            }
        }
    }

    private void addSandes(Scanner scanner) {
        scanner.nextLine();
        TipoSandes tipoSandes;

        if (sandwiches.size() >= MAX_SANDES) {
            System.out.println("Máximo de sandes atingido!");
        } else {
            System.out.println("Introduza a quantidade de sandes a adicionar:");
            int quantity = scanner.nextInt();

            scanner.nextLine(); // Consume newline left-over
            // Verify if its possible to add the quantity
            if (quantity > MAX_SANDES - sandwiches.size()) {
                System.out.println("Não é possível adicionar essa quantidade!");
            } else {
                System.out.println("Introduza o nome da sandes:");
                String name = scanner.nextLine();

                System.out.println("Introduza o preço:");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over 

                System.out.println("Introduza a data de validade (dd/mm/yyyy):");
                String expDate = scanner.nextLine();

                System.out.println("Introduza a referência: ");
                String reference = scanner.nextLine();

                System.out.println("Introduza o produtor: ");
                String brand = scanner.nextLine();

                System.out.println("Introduza o tipo de sandes\n1 - Mista\n2 - Fiambre\n3 - Queijo:");
                int sandesType = scanner.nextInt();

                scanner.nextLine(); // Consume newline left-over
                switch (sandesType) {
                    case 1 -> {
                        tipoSandes = TipoSandes.MISTA;
                    }
                    case 2 -> {
                        tipoSandes = TipoSandes.FIAMBRE;
                    }
                    case 3 -> {
                        tipoSandes = TipoSandes.QUEIJO;
                    }
                    default -> {
                        System.out.println("Tipo de sandes inválido!");
                        return;
                    }
                }
                System.out.println("Selecionado: " + tipoSandes);

                for (int i = 0; i < quantity; i++) {
                    Sandes novaSandes = new Sandes(name, price, expDate, reference, brand, tipoSandes);
                    
                    sandwiches.add(novaSandes);
                    System.out.println("Sandes adicionada com sucesso!");
                }

            }
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

    /* Client Menu - Buy Product */
    public void buyProduct(Scanner scanner) {
        System.out.println("Escolha o produto:");
        System.out.println("1 - Chocolate");
        System.out.println("2 - Refrigerante");
        System.out.println("3 - Sandes");
        System.out.println("4 - Sair");

        /* First select the type of product */
        int choice = scanner.nextInt();
        scanner.nextLine();

        /* List all type products*/
        switch (choice) {
            case 1 ->
                buyChocolate(scanner);
            case 2 ->
                buyRefrigerante(scanner);
            case 3 ->
                buySandes(scanner);
            case 4 ->
                System.out.println("Voltando ao menu principal.");
            default ->
                System.out.println("Opção inválida!");
        }
    }

    private void buyChocolate(Scanner scanner) {
        if (chocolates.isEmpty()) {
            System.out.println("Desculpe, não há chocolates disponíveis.");
        }
        // Implement chocolate buying logic
        /* Select a product by reference */
        for (int i = 0; i < chocolates.size(); i++) {
            System.out.println((i + 1) + " - " + chocolates.get(i).getNome());
        }

    }

    private void buyRefrigerante(Scanner scanner) {
        if (refrigerantes.isEmpty()) {
            System.out.println("Desculpe, não há refrigerantes disponíveis.");
        }
        // Implement refrigerante buying logic
        /* Select a product by reference */

    }

    private void buySandes(Scanner scanner) {
        if (sandwiches.isEmpty()) {
            System.out.println("Desculpe, não há sandes disponíveis.");
        }
        // Implement sandes buying logic
        /* Select a product by reference */

    }

}
