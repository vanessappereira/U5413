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
            System.out.println("--- 3. Sair              ---");
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
                    case 3:
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
                "6. Voltar ao menu principal\n" +
                "Selecione uma opção: ");
        try {
            int adminChoice = Integer.parseInt(scanner.nextLine());
            switch (adminChoice) {
                case 1 -> {
                    addProduct(scanner);
                }
                case 2 -> {
                    removeProduct(scanner);
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
                case 6 ->
                    showMainMenu(scanner, vendingMachine);
                default ->
                    System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido!");
        }
    }

    /* ===================== Product management ===================== */
    public void addProduct(Scanner scanner) {
        System.out.println("=== Adicionar Produto ===");
        System.out.println("1 - Chocolate (Max: " + (MAX_CHOCOLATES - chocolates.size()) + " unidades)");
        System.out.println("2 - Refrigerante (Max: " + (MAX_REFRIGERANTES - refrigerantes.size()) + " unidades)");
        System.out.println("3 - Sandes (Max: " + (MAX_SANDES - sandwiches.size()) + " unidades)");
        System.out.println("4 - Voltar");
        System.out.print("\nEscolha o tipo de produto: ");

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
                case 4:
                    System.out.println("Operação cancelada.");
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            scanner.nextLine(); // Clear buffer
            System.out.println("Erro: Input inválido!");
        }
    }

    // =========== Remove Product using scanner =========== //
    public void removeProduct(Scanner scanner) {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1 - Chocolate");
        System.out.println("2 - Refrigerante");
        System.out.println("3 - Sandes");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (choice) {
            case 1 ->
                removeChocolate(scanner);
            case 2 ->
                removeRefrigerante(scanner);
            case 3 ->
                removeSandes(scanner);
            default ->
                System.out.println("Opção inválida!");
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
            if (chocolate.getReferencia().equalsIgnoreCase(reference)) {
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
                chocolates.add(addChoc);

                // Increment ID
                addChoc.setReferencia(chocolates.size());
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
                refrigerantes.add(addRef);
                // Increment ID
                addRef.setReferencia(refrigerantes.size());
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
                sandwiches.add(addSandes);
                // Increment ID
                addSandes.setReferencia(sandwiches.size());
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
            System.out.println("Remoção cancelada.");
        } else if (selectedChocolate > 0 && selectedChocolate <= chocolates.size()) {
            // Remove the product from the list
            chocolates.remove(selectedChocolate - 1);
            System.out.println("Chocolate removido com sucesso!");
        }
        // save stock
        saveToFile();
    }

    // =========== Remove Refrigerante =========== //
    public void removeRefrigerante(Scanner scanner) {
    }

    // =========== Remove Sandes =========== //
    public void removeSandes(Scanner scanner) {
    }

    /* ===================== Menu Client ===================== */
    public void displayClientMenu(Scanner scanner, VendingMachine vendingMachine) {
        System.out.println("------- Menu Cliente -------");
        System.out.println("1. Comprar produto");
        System.out.println("2. Voltar ao menu principal");
        System.out.print("Selecione uma opção: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 ->
                buyProduct(scanner, vendingMachine);
            case 2 ->
                vendingMachine.showMainMenu(scanner, vendingMachine);
            default ->
                System.out.println("Opção inválida!");
        }
    }

    public void buyProduct(Scanner scanner, VendingMachine vendingMachine) {
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
            case 1 ->
                buyChocolate(scanner, vendingMachine);
            case 2 ->
                buyRefrigerante(scanner, vendingMachine);
            case 3 ->
                buySandes(scanner, vendingMachine);
            case 4 ->
                System.out.println("Voltando ao menu principal.");
            default ->
                System.out.println("Opção inválida!");
        }
    }

    // =========== Buy Chocolate =========== //
    private void buyChocolate(Scanner scanner, VendingMachine vendingMachine) {
        if (chocolates.isEmpty()) {
            System.out.println("Desculpe, não há chocolates disponíveis.");
        }
        System.out.println("=== Chocolates Disponíveis ===");
        System.out.println("=== " + chocolates.size() + " ===");
        for (Chocolate chocolate : chocolates) {
            System.out.printf("%s - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                    chocolate.getReferencia(),
                    chocolate.getRefBrand(),
                    chocolate.getNome(),
                    chocolate.getPreco(),
                    chocolate.getTipoCacau(),
                    chocolate.getMarca());
        }

        /* Select a product by reference */
        System.out.print("\nEscolha o chocolate pela referência: (0 para cancelar):");
        String reference = scanner.nextLine().trim();
        if (reference.equals("0")) {
            System.out.println("Compra cancelada.");
            return;
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
        if (refrigerantes.isEmpty()) {
            System.out.println("Desculpe, não há refrigerantes disponíveis.");
        }
        System.out.println("=== Refrigerantes Disponíveis ===");
        System.out.println("=== " + refrigerantes.size() + " ===");
        for (Refrigerante refrigerante : refrigerantes) {
            System.out.printf("%s - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                    refrigerante.getReferencia(),
                    refrigerante.getRefBrand(),
                    refrigerante.getNome(),
                    refrigerante.getPreco(),
                    refrigerante.getTipoRefri(),
                    refrigerante.getMarca());
        }

        /* Select a product by reference */
        System.out.print("\nEscolha o refrigerante pela referência: (0 para cancelar):");
        String reference = scanner.nextLine().trim();
        if (reference.equals("0")) {
            System.out.println("Compra cancelada.");
            return;
        }
        Refrigerante selectedRefrigerante = findRefrigeranteByReference(reference);
        if (selectedRefrigerante == null) {
            System.out.println("Refrigerante não encontrado. Tente novamente");
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
        }
        System.out.println("=== Sandes Disponíveis ===");
        System.out.println("=== " + sandwiches.size() + " ===");
        for (Sandes sandes : sandwiches) {
            System.out.printf("%s - %s - %s - %.2f \u20ac - Tipo: %s - Marca: %s%n",
                    sandes.getReferencia(),
                    sandes.getRefBrand(),
                    sandes.getNome(),
                    sandes.getPreco(),
                    sandes.getTipoSandes(),
                    sandes.getMarca());
        }

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

    private boolean simulatePayment(double amount, double paymentMoney) {
        System.out.println("Simulando pagamento");
        System.out.println("Valor a pagar: " + amount + "€");

        if (paymentMoney >= amount) {
            System.out.println("Pagamento realizado com sucesso!");
            double change = paymentMoney - amount;
            System.out.printf("Troco:  %.2f€ \n", change);
            return true;
        } else if (paymentMoney < amount) {
            System.out.println("Pagamento não realizado. Insuficiente dinheiro.");
            return false;
        }
        return true; // Simulate a successful payment
    }

    private void processPaymentChocolate(Chocolate selectedChocolate, Scanner scanner, VendingMachine vendingMachine) {
        System.out.printf("Você escolheu o chocolate: %s - Preço: %.2f €%n", selectedChocolate.getNome(),
                selectedChocolate.getPreco());

        double amount = 0.0;
        boolean validInput = false;

        // Loop until valid input is received
        while (!validInput) {
            System.out.print("Introduza as moedas para pagamento: ");
            String paymentMethod = scanner.nextLine().trim();

            try {
                amount = Double.parseDouble(paymentMethod);
                if (amount < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }

        boolean paymentSuccessful = simulatePayment(selectedChocolate.getPreco(), amount);

        if (paymentSuccessful) {
            System.out.println("Compra realizada com sucesso!");
            produtosVendidos.add(selectedChocolate);
            chocolates.remove(selectedChocolate);
            // Adicionar o valor do produto vendido ao total
            vendingMachine.totalVendas += selectedChocolate.getPreco();
        } else {
            System.out.println("Compra não realizada. Verifique se o valor inserido é suficiente.");
        }
    }

    private void processPaymentRefrigerante(Refrigerante selectedRefrigerante, Scanner scanner,
            VendingMachine vendingMachine) {
        System.out.printf("Você escolheu o refrigerante: %s - Preço: %.2f €%n", selectedRefrigerante.getNome(),
                selectedRefrigerante.getPreco());

        double amount = 0.0;
        boolean validInput = false;

        // Loop until valid input is received
        while (!validInput) {
            System.out.print("Introduza as moedas para pagamento: ");
            String paymentMethod = scanner.nextLine().trim();

            try {
                amount = Double.parseDouble(paymentMethod);
                if (amount < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }

        boolean paymentSuccessful = simulatePayment(selectedRefrigerante.getPreco(), amount);

        if (paymentSuccessful) {
            System.out.println("Compra realizada com sucesso!");
            produtosVendidos.add(selectedRefrigerante);
            refrigerantes.remove(selectedRefrigerante);

            // Adicionar o valor do produto vendido ao total
            vendingMachine.totalVendas += selectedRefrigerante.getPreco();
        } else {
            System.out.println("Compra não realizada. Verifique se o valor inserido é suficiente.");
        }
    }

    private void processPaymentSandes(Sandes selectedSandes, Scanner scanner, VendingMachine vendingMachine) {
        System.out.printf("Você escolheu a sandes: %s - Preço: %.2f €%n", selectedSandes.getNome(),
                selectedSandes.getPreco());

        double amount = 0.0;
        boolean validInput = false;

        // Loop until valid input is received
        while (!validInput) {
            System.out.print("Introduza as moedas para pagamento: ");
            String paymentMethod = scanner.nextLine().trim();

            try {
                amount = Double.parseDouble(paymentMethod);
                if (amount < 0) {
                    System.out.println("O valor não pode ser negativo. Tente novamente.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }

        boolean paymentSuccessful = simulatePayment(selectedSandes.getPreco(), amount);

        if (paymentSuccessful) {
            System.out.println("Compra realizada com sucesso!");
            produtosVendidos.add(selectedSandes);
            sandwiches.remove(selectedSandes);

            // Adicionar o valor do produto vendido ao total
            vendingMachine.totalVendas += selectedSandes.getPreco();
        } else {
            System.out.println("Compra não realizada. Verifique se o valor inserido é suficiente.");
        }
    }
}
