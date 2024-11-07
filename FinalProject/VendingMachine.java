package FinalProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import FinalProject.Chocolate.TipoCacau;
import FinalProject.Refrigerante.TipoRefri;
import FinalProject.Sandes.TipoSandes;

public class VendingMachine implements Serializable {

    private static final String STOCK_FILE = "FinalProject/stock.dat";

    // Constants
    private static final int MAX_CHOCOLATES = 20;
    private static final int MAX_REFRIGERANTES = 15;
    private static final int MAX_SANDES = 10;

    // Product Lists
    private final List<Chocolate> chocolates;
    private final List<Refrigerante> refrigerantes;
    private final List<Sandes> sandwiches;
    private final List<Produto> produtosVendidos;
    double totalVendas;

    public VendingMachine() {
        chocolates = new ArrayList<>();
        refrigerantes = new ArrayList<>();
        sandwiches = new ArrayList<>();
        produtosVendidos = new ArrayList<>();
        totalVendas = 0.0;
    }

    // File Operations
    public static VendingMachine loadFromFile() {
        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream(STOCK_FILE))) {
            return (VendingMachine) file.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading machine state: " + e.getMessage());
            return new VendingMachine();
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STOCK_FILE))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Error saving machine state: " + e.getMessage());
        }
    }

    // =========== Sales Management =========== //
    public void getSoldProducts() {
        System.out.println("Produtos vendidos:");
        for (Produto produto : produtosVendidos) {
            System.out.println(produto);
        }
        System.out.println("Total de vendas: " + totalVendas);
    }

    public double getTotalSales() {
        return totalVendas;
    }

    public void cleanHistorySales() {
        produtosVendidos.clear();
        totalVendas = 0.0;
        saveToFile();
    }

    public void displayTotalSales() {
        System.out.println("Histórico de vendas:");
        if (produtosVendidos.isEmpty()) {
            System.out.println("Nenhum produto foi vendido ainda.");
            return;
        } else {
            produtosVendidos.forEach(System.out::println);
            System.out.println("Total de vendas: " + totalVendas + "€");
        }
    }

    public void showMainMenu(Scanner scanner, VendingMachine vendingMachine) {
        while (true) {
            System.out.println("----- Máquina de Venda -----");
            System.out.println("--- 1. Cliente           ---");
            System.out.println("--- 2. Admin             ---");
            System.out.println("--- 0. Sair              ---");
            System.out.print("Selecione uma opção: ");

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Opção inválida. Por favor, tente novamente.");
                continue;
            }
            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        displayClientMenu(scanner, vendingMachine);
                        break;
                    case 2:
                        displayAdminMenu(scanner, vendingMachine);
                        break;
                    case 0:
                        exitProgram(vendingMachine);
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        }
    }

    private static void exitProgram(VendingMachine vendingMachine) {
        System.out.println("Obrigado por usar a Máquina de Venda!");
        vendingMachine.saveToFile();
        System.exit(0);
    }

    /* ===================== Menu Admin ===================== */
    public void displayAdminMenu(Scanner scanner, VendingMachine vendingMachine) {
        System.out.println("----- Menu Admin -----\n" +
                "1. Adicionar produto\n" +
                "2. Remover produto\n" +
                "3. Consultar valor total de vendas\n" +
                "4. Visualizar Histórico\n" +
                "5. Limpar Histórico\n" +
                "9. Voltar ao menu principal\n" +
                "Selecione uma opção: ");
        try {
            int adminChoice = Integer.parseInt(scanner.nextLine());
            switch (adminChoice) {
                case 1 -> {
                    addProduct(scanner, vendingMachine);
                }
                case 2 -> {
                    removeProduct(scanner, vendingMachine);
                }
                case 3 -> {
                    displayTotalSales();
                }
                case 4 -> {
                    getSoldProducts();
                }
                case 5 -> {
                    cleanHistorySales();
                }
                case 9 ->
                    showMainMenu(scanner, vendingMachine);
                default ->
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido!");
        }
    }

    /* ===================== Product management ===================== */
    public void addProduct(Scanner scanner, VendingMachine vendingMachine) {
        System.out.println("=== Adicionar Produto ===");
        System.out.println("1 - Chocolate (Disponível: " + (MAX_CHOCOLATES - chocolates.size()) + " unidades)");
        System.out
                .println("2 - Refrigerante (Disponível: " + (MAX_REFRIGERANTES - refrigerantes.size()) + " unidades)");
        System.out.println("3 - Sandes (Disponível: " + (MAX_SANDES - sandwiches.size()) + " unidades)");
        System.out.println("9 - Voltar");
        System.out.print("\nEscolha a opção: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addChocolate(scanner);
                case 2:
                    addRefrigerante(scanner);
                case 3:
                    addSandwich(scanner);
                case 9:
                    System.out.println("Operação cancelada.");
                    showMainMenu(scanner, vendingMachine);
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            scanner.nextLine(); // Clear buffer
            System.out.println("Erro: Input inválido!");
        }
    }

    // =========== List Products =========== //
    private void listChocolates() {
        System.out.println("\n======= Chocolates =======");
        if (chocolates.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
        } else {
            System.out.println("=== Chocolates Disponíveis: " + chocolates.size() + " ===");
            for (Chocolate chocolate : chocolates) {
                System.out.printf("%s - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                        chocolate.getReferencia(),
                        chocolate.getRefBrand(),
                        chocolate.getNome(),
                        chocolate.getPreco(),
                        chocolate.getTipoCacau(),
                        chocolate.getMarca());
            }
        }
    }

    private void listRefrigerantes() {
        System.out.println("\n======= Refrigerantes =======");
        if (refrigerantes.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
        } else {
            System.out.println("=== Refrigerantes Disponíveis:" + refrigerantes.size() + " ===");
            for (Refrigerante refrigerante : refrigerantes) {
                System.out.printf("%s - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                        refrigerante.getReferencia(),
                        refrigerante.getRefBrand(),
                        refrigerante.getNome(),
                        refrigerante.getPreco(),
                        refrigerante.getTipoRefri(),
                        refrigerante.getMarca());
            }
        }
    }

    private void listSandes() {
        System.out.println("=== Sandes Disponíveis ===" + sandwiches.size() + " ===");
        for (Sandes sandes : sandwiches) {
            System.out.printf("%s - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                    sandes.getReferencia(),
                    sandes.getRefBrand(),
                    sandes.getNome(),
                    sandes.getPreco(),
                    sandes.getTipoSandes(),
                    sandes.getMarca());
        }
    }

    // =========== Remove Product using scanner =========== //
    public void removeProduct(Scanner scanner, VendingMachine vendingMachine) {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1 - Chocolate");
        System.out.println("2 - Refrigerante");
        System.out.println("3 - Sandes");
        System.out.println("9 - Voltar");
        System.out.print("\nEscolha a opção: ");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    removeChocolate(scanner);
                case 2:
                    removeRefrigerante(scanner);
                case 3:
                    removeSandes(scanner);
                case 9:
                    System.out.println("Operação cancelada.");
                    showMainMenu(scanner, vendingMachine);
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            scanner.nextLine(); // Clear buffer
            System.out.println("Erro: Input inválido!");
        }
    }

    /* ===================== Getter Methods ===================== */
    public List<Chocolate> getChocolates() {
        return new ArrayList<>(chocolates);
    }

    public List<Refrigerante> getRefrigerantes() {
        return new ArrayList<>(refrigerantes);
    }

    public List<Sandes> getSandwiches() {
        return new ArrayList<>(sandwiches);
    }

    private TipoCacau getTipoChocolate(Scanner scanner) {
        System.out.println("""
                Selecione o tipo de chocolate:
                1 - Branco
                2 - Leite
                3 - Negro""");
        return switch (scanner.nextInt()) {
            case 1 -> TipoCacau.BRANCO;
            case 2 -> TipoCacau.LEITE;
            case 3 -> TipoCacau.NEGRO;
            default -> throw new IllegalArgumentException("Tipo de chocolate inválido!");
        };
    }

    private TipoRefri getTipoRefrigerante(Scanner scanner) {
        System.out.println("""
                Selecione o tipo de refrigerante:
                1 - Normal
                2 - Sem Açúcar""");
        return switch (scanner.nextInt()) {
            case 1 -> TipoRefri.NORMAL;
            case 2 -> TipoRefri.SUGARFREE;
            default -> throw new IllegalArgumentException("Tipo de refrigerante inválido!");
        };
    }

    private TipoSandes getTipoSandes(Scanner scanner) {
        System.out.println("""
                Selecione o tipo de sandes:
                1 - Mista
                2 - Fiambre
                3 - Queijo""");
        return switch (scanner.nextInt()) {
            case 1 -> TipoSandes.MISTA;
            case 2 -> TipoSandes.FIAMBRE;
            case 3 -> TipoSandes.QUEIJO;
            default -> throw new IllegalArgumentException("Tipo de sandes inválido!");
        };
    }

    /* ===================== Helper Methods ===================== */
    // Validate user input for quantity
    private int validarQuantidadeInput(Scanner scanner, int maxAllowed) {
        int quantity = scanner.nextInt();
        if (quantity <= 0 || quantity > maxAllowed) {
            throw new IllegalArgumentException("Quantidade Inválida!");
        }
        return quantity;
    }

    // Record to store product information
    private record ProdutoInfo(String name, double price, String expDate,
            String reference, String brand) {
    }

    // Get product information from user input
    private ProdutoInfo getInfoProduto(Scanner scanner) {
        scanner.nextLine();

        System.out.println("\n=== Informações do Produto ===");
        System.out.print("Nome do produto: ");
        String name = scanner.nextLine().trim();

        while (name.isEmpty()) {
            System.out.println("O nome não pode estar vazio!");
            System.out.print("Nome do produto: ");
            name = scanner.nextLine().trim();
        }

        double price;
        do {
            System.out.print("Preço (€): ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("O preço deve ser maior que zero!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um valor numérico válido!");
            }
        } while (true);

        System.out.print("Data de validade (dd/mm/aaaa): ");
        String expDate = scanner.nextLine().trim();
        while (!expDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Formato de data inválido! Use dd/mm/aaaa");
            System.out.print("Data de validade (dd/mm/aaaa): ");
            expDate = scanner.nextLine().trim();
        }

        System.out.print("Referência do produto: ");
        String reference = scanner.nextLine().trim();
        while (reference.isEmpty()) {
            System.out.println("A referência não pode estar vazia!");
            System.out.print("Referência do produto: ");
            reference = scanner.nextLine().trim();
        }

        System.out.print("Marca/Produtor: ");
        String brand = scanner.nextLine().trim();
        while (brand.isEmpty()) {
            System.out.println("A marca não pode estar vazia!");
            System.out.print("Marca/Produtor: ");
            brand = scanner.nextLine().trim();
        }

        return new ProdutoInfo(name, price, expDate, reference, brand);
    }

    private Chocolate findChocolateByReference(String reference) {
        for (Chocolate chocolate : chocolates) {
            if (chocolate.getRefBrand().equalsIgnoreCase(reference)) {
                return chocolate; // Return the found chocolate
            }
        }
        return null; // Return null if no chocolate is found
    }

    public Refrigerante findRefrigeranteByReference(String reference) {
        for (Refrigerante refrigerante : refrigerantes) {
            if (refrigerante.getReferencia().equalsIgnoreCase(reference)) {
                return refrigerante; // Return the found refrigerante
            }
        }
        return null; // Return null if no refrigerante is found
    }

    public Sandes findSandesByReference(String reference) {
        for (Sandes sandes : sandwiches) {
            if (sandes.getReferencia().equalsIgnoreCase(reference)) {
                return sandes; // Return the found sandes
            }
        }
        return null; // Return null if no sandes is found
    }

    /* ===================== Product management ===================== */
    // =========== Add Chocolate =========== //
    public void addChocolate(Scanner scanner) {
        Chocolate addChoc;
        TipoCacau tipoCacau;

        if (chocolates.size() >= MAX_CHOCOLATES) {
            System.out.println("Erro: Máximo de chocolates atingido!");
            return;
        }
        try {
            System.out.println("=== Adicionar Chocolate ===");
            System.out.printf("Quantidade disponível: %d unidades\n", MAX_CHOCOLATES - chocolates.size());

            System.out.print("Introduza a quantidade a adicionar: ");
            int qntd = validarQuantidadeInput(scanner, MAX_CHOCOLATES - chocolates.size());

            ProdutoInfo info = getInfoProduto(scanner);
            tipoCacau = getTipoChocolate(scanner);

            for (int i = 0; i < qntd; i++) {
                addChoc = new Chocolate(info.name, info.price, info.expDate, info.reference, info.brand, tipoCacau);
                // Increment ID
                addChoc.setReferencia(chocolates.size());

                chocolates.add(addChoc);
            }
            scanner.nextLine();// Clear buffer

            System.out.println("Sucesso: " + qntd + " chocolate(s) adicionado(s)!");
            saveToFile();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // =========== Add Refrigerante =========== //
    public void addRefrigerante(Scanner scanner) {
        Refrigerante addRef;
        TipoRefri tipoRefrigerante;

        if (refrigerantes.size() <= MAX_REFRIGERANTES) {
            System.out.println("Máximo de refrigerantes atingido!");
        }
        try {
            System.out.println("=== Adicionar Refrigerante ===");
            System.out.printf("Quantidade disponível: %d unidades\n", MAX_REFRIGERANTES - refrigerantes.size());

            System.out.print("Introduza a quantidade a adicionar: ");
            int qntd = validarQuantidadeInput(scanner, MAX_REFRIGERANTES - refrigerantes.size());

            ProdutoInfo info = getInfoProduto(scanner);
            tipoRefrigerante = getTipoRefrigerante(scanner);

            for (int i = 0; i < qntd; i++) {
                addRef = new Refrigerante(info.name, info.price, info.expDate, info.reference, info.brand,
                        tipoRefrigerante);

                // Increment ID
                addRef.setReferencia(refrigerantes.size());

                refrigerantes.add(addRef);
            }
            scanner.nextLine();// Clear buffer

            System.out.println("Sucesso: " + qntd + " refrigerante(s) adicionado!");
            saveToFile();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // =========== Add Sandes =========== //
    public void addSandwich(Scanner scanner) {
        Sandes addSandes;
        TipoSandes tipoSandes;

        if (sandwiches.size() >= MAX_SANDES) {
            System.out.println("Máximo de sandes atingido!");
        }
        try {
            System.out.println("=== Adicionar Sandes ===");
            System.out.printf("Quantidade disponível: %d unidades\n", MAX_SANDES - sandwiches.size());

            System.out.print("Introduza a quantidade a adicionar: ");
            int qntd = validarQuantidadeInput(scanner, MAX_SANDES - sandwiches.size());

            ProdutoInfo info = getInfoProduto(scanner);
            tipoSandes = getTipoSandes(scanner);

            for (int i = 0; i < qntd; i++) {
                addSandes = new Sandes(info.name, info.price, info.expDate, info.reference, info.brand, tipoSandes);

                // Increment ID
                addSandes.setReferencia(sandwiches.size());

                sandwiches.add(addSandes);
            }
            scanner.nextLine();// Clear buffer

            System.out.println("Sucesso: " + qntd + " sandes adicionada(s)!");
            saveToFile();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // =========== Remove Chocolate =========== //
    public void removeChocolate(Scanner scanner) {
        // List al chocolates
        for (Chocolate chocolate : chocolates) {
            System.out.printf("%d - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                    chocolate.getReferencia(),
                    chocolate.getRefBrand(),
                    chocolate.getNome(),
                    chocolate.getPreco(),
                    chocolate.getTipoCacau(),
                    chocolate.getMarca());
        }
        /* Select a product by reference */
        System.out.print("\nEscolha o chocolate pela referência ID: (0 para cancelar):");
        int selectedChocolate = scanner.nextInt();

        scanner.nextLine(); // Consume newline left-over

        if (selectedChocolate == 0) {
            System.out.print("Remoção cancelada.");
        } else if (selectedChocolate > 0 && selectedChocolate <= chocolates.size()) {
            // Remove the product from the list
            chocolates.remove(selectedChocolate - 1);
            System.out.print("Chocolate removido com sucesso!");
        }
        // save stock
        saveToFile();
    }

    // =========== Remove Refrigerante =========== //
    public void removeRefrigerante(Scanner scanner) {
        // List all refrigerantes
        for (Refrigerante refrigerante : refrigerantes) {
            System.out.printf("%d - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                    refrigerante.getReferencia(),
                    refrigerante.getRefBrand(),
                    refrigerante.getNome(),
                    refrigerante.getPreco(),
                    refrigerante.getTipoRefri(),
                    refrigerante.getMarca());
        }
        /* Select a product by reference */
        System.out.print("\nEscolha o refrigerante pela referência ID: (0 para cancelar):");
        int selectedRefrigerante = scanner.nextInt();

        scanner.nextLine(); // Consume newline left-over

        if (selectedRefrigerante == 0) {
            System.out.println("Remoção cancelada.");
        } else if (selectedRefrigerante > 0 && selectedRefrigerante <= chocolates.size()) {
            // Remove the product from the list
            chocolates.remove(selectedRefrigerante - 1);
            System.out.println("Refrigerante removido com sucesso!");
        }
        // save stock
        saveToFile();
    }

    // =========== Remove Sandes =========== //
    public void removeSandes(Scanner scanner) {
        // List all sandes
        for (Sandes sandes : sandwiches) {
            System.out.printf("%d - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                    sandes.getReferencia(),
                    sandes.getRefBrand(),
                    sandes.getNome(),
                    sandes.getPreco(),
                    sandes.getTipoSandes(),
                    sandes.getMarca());
        }
        /* Select a product by reference */
        System.out.print("\nEscolha a sandes pela referência ID: (0 para cancelar):");
        int selectedSandes = scanner.nextInt();

        scanner.nextLine(); // Consume newline left-over

        if (selectedSandes == 0) {
            System.out.println("Remoção cancelada.");
        } else if (selectedSandes > 0 && selectedSandes <= chocolates.size()) {
            // Remove the product from the list
            chocolates.remove(selectedSandes - 1);
            System.out.println("Sandes removido com sucesso!");
        }
        // save stock
        saveToFile();
    }

    /* ===================== Menu Client ===================== */
    public void displayClientMenu(Scanner scanner, VendingMachine vendingMachine) {
        System.out.println("------- Menu Cliente -------");
        System.out.println("1. Comprar produto");
        System.out.println("9. Voltar ao menu principal");
        System.out.print("Selecione uma opção: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 ->
                buyProduct(scanner, vendingMachine);
            case 9 ->
                vendingMachine.showMainMenu(scanner, vendingMachine);
            default ->
                System.out.println("Opção inválida!");
        }
    }

    public void buyProduct(Scanner scanner, VendingMachine vendingMachine) {
        System.out.println("======= Produtos disponíveis =======");
        // List all products
        listChocolates();
        listRefrigerantes();
        listSandes();
        System.out.println("======= Opções =======");
        System.out.println("1 - Chocolate");
        System.out.println("2 - Refrigerante");
        System.out.println("3 - Sandes");
        System.out.println("9 - Voltar");
        System.out.print("\nEscolha o produto:");

        /* First select the type of product */
        int choice = scanner.nextInt();
        scanner.nextLine();

        /* List all type products */
        switch (choice) {
            case 1 ->
                buyChocolate(scanner, vendingMachine);
            case 2 ->
                buyRefrigerante(scanner, vendingMachine);
            case 3 ->
                buySandes(scanner, vendingMachine);
            case 9 -> {
                System.out.println("Voltando ao menu principal.");
                showMainMenu(scanner, vendingMachine);
            }
            default ->
                System.out.println("Opção inválida!");
        }
    }

    // =========== Buy Chocolate =========== //
    private void buyChocolate(Scanner scanner, VendingMachine vendingMachine) {
        if (chocolates.isEmpty()) {
            System.out.println("Desculpe, não há chocolates disponíveis.");
            showMainMenu(scanner, vendingMachine);
        }
        listChocolates();

        /* Select a product by reference */
        System.out.print("\nEscolha o chocolate pela referência: (0 para voltar):");
        String reference = scanner.nextLine().trim();
        if (reference.equals("0")) {
            System.out.println("Compra cancelada.");
            displayClientMenu(scanner, vendingMachine);
        }
        Chocolate selectedChocolate = findChocolateByReference(reference);
        if (selectedChocolate == null) {
            System.out.println("Chocolate não encontrado. Tente novamente");
            return;
        }

        // Proceed with payment
        processPaymentChocolate(selectedChocolate, scanner, vendingMachine);
        saveToFile();
    }

    // =========== Buy Refrigerantes =========== //
    private void buyRefrigerante(Scanner scanner, VendingMachine vendingMachine) {
        if (refrigerantes.isEmpty() || refrigerantes.size() == 0) {
            System.out.println("Desculpe, não há refrigerantes disponíveis.");
            showMainMenu(scanner, vendingMachine);
        }
        listRefrigerantes();

        /* Select a product by reference */
        System.out.print("\nEscolha o refrigerante pela referência: (0 para cancelar):");
        String reference = scanner.nextLine().trim();
        if (reference.equals("0")) {
            System.out.print("Compra cancelada.");
            return;
        }
        Refrigerante selectedRefrigerante = findRefrigeranteByReference(reference);
        if (selectedRefrigerante == null) {
            System.out.print("Refrigerante não encontrado. Tente novamente");
            return;
        }

        // Proceed with payment
        processPaymentRefrigerante(selectedRefrigerante, scanner, vendingMachine);
        saveToFile();
    }

    // =========== Buy Sandes =========== //
    private void buySandes(Scanner scanner, VendingMachine vendingMachine) {
        if (sandwiches.isEmpty()) {
            System.out.println("Desculpe, não há sandes disponíveis.");
            showMainMenu(scanner, vendingMachine);
        }
        listSandes();

        /* Select a product by reference */
        System.out.print("\nEscolha a sandes pela referência: (0 para cancelar):");
        String reference = scanner.nextLine().trim();
        if (reference.equals("0")) {
            System.out.println("Compra cancelada.");
            return;
        }
        Sandes selectedSandes = findSandesByReference(reference);
        if (selectedSandes == null) {
            System.out.println("Sandes não encontrada. Tente novamente");
            return;
        }

        // Proceed with payment
        processPaymentSandes(selectedSandes, scanner, vendingMachine);
        saveToFile();
    }

    private void processPaymentChocolate(Chocolate selectedChocolate, Scanner scanner, VendingMachine vendingMachine) {
        System.out.printf("Você escolheu o chocolate: %s - Preço: %.2f €%n", selectedChocolate.getNome(),
                selectedChocolate.getPreco());

        double totalInserted = 0.0; // Initialize total inserted amount
        boolean paymentSuccessful = false;

        while (!paymentSuccessful) {
            System.out.print("Introduza as moedas para pagamento: ");
            String paymentMethod = scanner.nextLine().trim();

            try {
                double amount = Double.parseDouble(paymentMethod);
                if (amount < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                    continue; // Ask for input again
                }

                totalInserted += amount; // Add the inserted amount to the total
                System.out.printf("Total inserido até agora: %.2f €%n", totalInserted);

                if (totalInserted < selectedChocolate.getPreco()) {
                    System.out.printf("Valor ainda insuficiente. Faltam %.2f € para completar o pagamento.%n",
                            selectedChocolate.getPreco() - totalInserted);
                } else {
                    // Payment successful
                    paymentSuccessful = true;
                    double change = totalInserted - selectedChocolate.getPreco();
                    System.out.println("Pagamento realizado com sucesso!");
                    if (change > 0) {
                        System.out.printf("Troco: %.2f €%n", change);
                    }
                    produtosVendidos.add(selectedChocolate);
                    chocolates.remove(selectedChocolate);

                    // Add product value to total sales
                    vendingMachine.totalVendas += selectedChocolate.getPreco();
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }
    }

    private void processPaymentRefrigerante(Refrigerante selectedRefrigerante, Scanner scanner,
            VendingMachine vendingMachine) {
        System.out.printf("Você escolheu o refrigerante: %s - Preço: %.2f €%n", selectedRefrigerante.getNome(),
                selectedRefrigerante.getPreco());

        double totalInserted = 0.0; // Initialize total inserted amount
        boolean paymentSuccessful = false;

        while (!paymentSuccessful) {
            System.out.print("Introduza as moedas para pagamento: ");
            String paymentMethod = scanner.nextLine().trim();

            try {
                double amount = Double.parseDouble(paymentMethod);
                if (amount < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                    continue; // Ask for input again
                }

                totalInserted += amount; // Add the inserted amount to the total
                System.out.printf("Total inserido até agora: %.2f €%n", totalInserted);

                if (totalInserted < selectedRefrigerante.getPreco()) {
                    System.out.printf("Valor ainda insuficiente. Faltam %.2f € para completar o pagamento.%n",
                            selectedRefrigerante.getPreco() - totalInserted);
                } else {
                    // Payment successful
                    paymentSuccessful = true;
                    double change = totalInserted - selectedRefrigerante.getPreco();
                    System.out.println("Pagamento realizado com sucesso!");
                    if (change > 0) {
                        System.out.printf("Troco: %.2f €%n", change);
                    }
                    produtosVendidos.add(selectedRefrigerante);
                    refrigerantes.remove(selectedRefrigerante);

                    // Adicionar o valor do produto vendido ao total
                    vendingMachine.totalVendas += selectedRefrigerante.getPreco();
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }
    }

    private void processPaymentSandes(Sandes selectedSandes, Scanner scanner, VendingMachine vendingMachine) {
        System.out.printf("Você escolheu a sandes: %s - Preço: %.2f €%n", selectedSandes.getNome(),
                selectedSandes.getPreco());

        double totalInserted = 0.0; // Initialize total inserted amount
        boolean paymentSuccessful = false;

        while (!paymentSuccessful) {
            System.out.print("Introduza as moedas para pagamento: ");
            String paymentMethod = scanner.nextLine().trim();

            try {
                double amount = Double.parseDouble(paymentMethod);
                if (amount < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                    continue; // Ask for input again
                }

                totalInserted += amount; // Add the inserted amount to the total
                System.out.printf("Total inserido até agora: %.2f €%n", totalInserted);

                if (totalInserted < selectedSandes.getPreco()) {
                    System.out.printf("Valor ainda insuficiente. Faltam %.2f € para completar o pagamento.%n",
                            selectedSandes.getPreco() - totalInserted);
                } else {
                    // Payment successful
                    paymentSuccessful = true;
                    double change = totalInserted - selectedSandes.getPreco();
                    System.out.println("Pagamento realizado com sucesso!");
                    if (change > 0) {
                        System.out.printf("Troco: %.2f €%n", change);
                    }
                    produtosVendidos.add(selectedSandes);
                    sandwiches.remove(selectedSandes);

                    // Adicionar o valor do produto vendido ao total
                    vendingMachine.totalVendas += selectedSandes.getPreco();
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }
    }

    public void addChocolate2(Chocolate chocolate) {
        // Increment ID
        chocolate.setReferencia(chocolates.size());

        chocolates.add(chocolate);
    }

    public void addRefrigerante2(Refrigerante refrigerante) {
        // Increment ID
        refrigerante.setReferencia(refrigerantes.size());

        refrigerantes.add(refrigerante);
    }

    public void addSandes2(Sandes sandes) {
        // Increment ID
        sandes.setReferencia(sandwiches.size());

        sandwiches.add(sandes);
    }

}
