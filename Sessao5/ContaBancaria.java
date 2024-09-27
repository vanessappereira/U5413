package Sessao5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*     
    numeroConta (int)
    saldo (double), que inicia sempre a zero
    nrmovimentos(int), que inicia sempre a zero

Implemente os seguintes métodos para:
   - Depositar um valor na conta.
   - Contabilizar o total de movimentos efetuados (a cada levantamento ou depósito)
   - Mostrar o total de movimentos efetuados
   - Levantar um valor da conta, garantindo que o saldo nunca fique negativo.
   - Mostrar o saldo atual. 
 */
public class ContaBancaria {

    /* Atributes */
    private final int numeroConta;
    private double saldo;
    private int nrmovimentos;
    private List<String> movimentos; // List para guardar os movimentos

    /* Constructor */
    public ContaBancaria(int numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0;
        this.nrmovimentos = 0;
        this.movimentos = new ArrayList<>();
    }

    public double depositar(double amount) {
        if (amount > 0) {
            this.saldo += amount;
            this.nrmovimentos++;

            System.out.println("Depósito realizado com sucesso!\n Saldo atual: " + saldo);

            System.out.println("Movimentos totais: " + nrmovimentos + "\n");

            // Store movement detail
            this.movimentos.add("Depósito de " + amount + " EUR");

            return this.saldo;
        } else {
            System.out.println("Valor inválido para depósito");
            return this.saldo;
        }
    }

    public double levantamento(double amount) {
        if (amount > saldo) {
            System.out.println("Saldo insuficiente para o levantamento");

            return this.saldo;
        }

        if (amount < 0) {
            System.out.println("Valor inválido para levantamento");

            return this.saldo;
        } else {
            saldo -= amount;
            nrmovimentos++;

            System.out.println("Levantamento realizado com sucesso!\n Saldo atual: " + saldo);

            System.out.println("Movimentos totais: " + nrmovimentos + "\n");

            // Store movement detail
            this.movimentos.add("Levantamento de " + amount);

            return this.saldo;
        }
    }

    /* Displays the current balance. */
    public void consultarSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }

    /* Displays the total number of transactions. */
    public void consultarMovimentos() {
        System.out.println("Movimentos totais: " + this.nrmovimentos);
        for (String movimento : this.movimentos) {
            System.out.println(movimento);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria(12345);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Depositar");
            System.out.println("2. Levantar");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Consultar Movimentos");
            System.out.println("0. Sair");

            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> {
                        System.out.print("Digite o valor para depósito: ");
                        double depositAmount = scanner.nextDouble();
                        conta.depositar(depositAmount);
                        break;
                    }
                    case 2 -> {
                        System.out.print("Digite o valor para levantamento: ");
                        double withdrawalAmount = scanner.nextDouble();
                        conta.levantamento(withdrawalAmount);
                        break;
                    }
                    case 3 ->
                        conta.consultarSaldo();
                    case 4 ->
                        conta.consultarMovimentos();
                    case 0 -> {
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    }
                    default ->
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
