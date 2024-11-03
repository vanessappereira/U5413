package FinalProject;

import java.util.Scanner;

public class Main {
    private static VendingMachine machine;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        machine = VendingMachine.loadFromFile();
        machine.showMainMenu(scanner, machine);
    }
}
