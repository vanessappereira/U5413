package FinalProject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import FinalProject.Chocolate.TipoCacau;
import FinalProject.Refrigerante.TipoRefri;
import FinalProject.Sandes.TipoSandes;

public class StockFileCreator {
    private static final String FILE_NAME = "FinalProject/stock.dat";

    public static void main(String[] args) {
        // Create and initialize the vending machine
        VendingMachine vendingMachine = new VendingMachine();

        addProductsToVendingMachine(vendingMachine);

        // Save updated machine state to file
        saveVendingMachineState(vendingMachine);
    }

    private static void addProductsToVendingMachine(VendingMachine vendingMachine) {
        addChocolates(vendingMachine);
        addBeverages(vendingMachine);
        addSandwiches(vendingMachine);
    }

    private static void addChocolates(VendingMachine vendingMachine) {
        Chocolate[] chocolates = {
                new Chocolate("White Oreo", 2.75, "2024-06-30", "CH003", "Milka", TipoCacau.BRANCO),
                new Chocolate("Premium Dark 70%", 3.50, "2024-06-30", "CH004", "Godiva", TipoCacau.NEGRO),
                new Chocolate("Milk with Nuts", 2.90, "2024-06-30", "CH005", "Lindt", TipoCacau.LEITE),
                new Chocolate("White Strawberry", 2.80, "2024-06-30", "CH006", "Nestlé", TipoCacau.BRANCO),
                new Chocolate("Dark Orange", 3.20, "2024-06-30", "CH007", "Lindt", TipoCacau.NEGRO)
        };

        addProducts(vendingMachine, chocolates);
    }

    private static void addBeverages(VendingMachine vendingMachine) {
        Refrigerante[] beverages = {
                new Refrigerante("Orange Soda", 1.50, "2024-03-31", "RF003", "Fanta", TipoRefri.NORMAL),
                new Refrigerante("Zero Sugar Cola", 1.50, "2024-03-31", "RF004", "Pepsi", TipoRefri.SUGARFREE),
                new Refrigerante("Lemon Zero", 1.50, "2024-03-31", "RF005", "Sprite", TipoRefri.SUGARFREE)
        };

        addProducts(vendingMachine, beverages);
    }

    private static void addSandwiches(VendingMachine vendingMachine) {
        Sandes[] sandwiches = {
                new Sandes("Mixed Deluxe", 4.50, "2023-07-15", "SW003", "Fresh Foods", TipoSandes.MISTA),
                new Sandes("Premium Ham & Butter", 4.00, "2023-07-15", "SW004", "Gourmet Deli", TipoSandes.FIAMBRE),
                new Sandes("Special Cheese", 4.00, "2023-07-15", "SW005", "Gourmet Deli", TipoSandes.QUEIJO)
        };

        addProducts(vendingMachine, sandwiches);
    }

    private static <T> void addProducts(VendingMachine vendingMachine, T[] products) {
        for (T product : products) {
            if (product instanceof Chocolate) {
                vendingMachine.addChocolate2((Chocolate) product);
            } else if (product instanceof Refrigerante) {
                vendingMachine.addRefrigerante2((Refrigerante) product);
            } else if (product instanceof Sandes) {
                vendingMachine.addSandes2((Sandes) product);
            }
        }
    }

    private static void saveVendingMachineState(VendingMachine vendingMachine) {
        try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(vendingMachine);
            System.out.println("Vending machine state saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving vending machine state: " + e.getMessage());
        }
    }
}
