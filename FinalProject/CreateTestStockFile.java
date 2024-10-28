package FinalProject;

import FinalProject.Chocolate.TipoCacau;
import FinalProject.Refrigerante.TipoRefri;
import FinalProject.Sandes.TipoSandes;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreateTestStockFile {

    public static void main(String[] args) {
        VendingMachine testMachine = new VendingMachine();

        // Create sample products
        Chocolate darkChocolate = new Chocolate("Dark Chocolate", 2.50, "2023-12-31", "CH001", "Lindt", TipoCacau.NEGRO);
        Chocolate milkChocolate = new Chocolate("Milk Chocolate", 2.00, "2023-12-31", "CH002", "Cadbury", TipoCacau.LEITE);
        Refrigerante cola = new Refrigerante("Cola", 1.50, "2023-12-31", "RF001", "Coca-Cola", TipoRefri.NORMAL);
        Refrigerante lemonSoda = new Refrigerante("Lemon Soda", 1.50, "2023-12-31", "RF002", "Sprite", TipoRefri.SUGARFREE);
        Sandes hamSandwich = new Sandes("Ham Sandwich", 3.50, "2023-06-30", "SW001", "Fresh Foods", TipoSandes.FIAMBRE);
        Sandes cheeseSandwich = new Sandes("Cheese Sandwich", 3.50, "2023-06-30", "SW002", "Fresh Foods", TipoSandes.QUEIJO);

        // Add products to the machine
        testMachine.getChocolates().add(darkChocolate);
        testMachine.getChocolates().add(milkChocolate);
        testMachine.getRefrigerantes().add(cola);
        testMachine.getRefrigerantes().add(lemonSoda);
        testMachine.getSandwiches().add(hamSandwich);
        testMachine.getSandwiches().add(cheeseSandwich);

        // Save the test machine to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FinalProject/stock.dat"))) {
            oos.writeObject(testMachine);
            System.out.println("Test stock.dat file created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating test stock.dat file: " + e.getMessage());
        }
    }
}
