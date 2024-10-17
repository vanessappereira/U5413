package Sessao3.Parte3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContaBancaria {

    // Atributos da classe
    private int nrConta, nrMovimentos = 0;
    private double saldo = 0;
    private List<String> movimentos; // lista de movimentos da conta

    public ContaBancaria(int nrConta) {
        this.nrConta = nrConta;
        this.movimentos = new ArrayList<>();
    }

    /* Setters e Getters */
    public int getNrConta() {
        return nrConta;
    }

    public void setNrConta(int nrConta) {
        this.nrConta = nrConta;
    }

    public int getNrMovimentos() {
        return nrMovimentos;
    }

    public void setNrMovimentos(int nrMovimentos) {
        this.nrMovimentos = nrMovimentos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<String> getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(List<String> movimentos) {
        this.movimentos = movimentos;
    }

    // Depositar um valor na conta
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            nrMovimentos++;
            movimentos.add("Depósito: " + valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    // Levantar valor da conta
    public void levantar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            nrMovimentos++;
            movimentos.add("Levantamento: " + valor);
            System.out.println("Levantamento realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }

    // Mostrar movimentos efetuados
    public void consultarMovimentos(int nrConta) {
        System.out.println("Movimentos da conta " + nrConta + ":");
        // Verificar se existe movimentos
        if (nrMovimentos == 0) {
            System.out.println("Não existem movimentos realizados.");
        } else {
            //Mostrar nr de movimentos
            System.out.println("Número de movimentos: " + nrMovimentos);

            // Mostrar movimentos
            System.out.println("Lista dos movimentos:");
            for (String movimento : movimentos) {
                System.out.println(movimento);
            }
        }
    }

    // Mostrar saldo
    public double consultarSaldo(int nrConta) {
        System.out.println("Saldo da conta " + nrConta + ": " + this.saldo);
        return this.saldo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número da conta: ");
        int nrConta = scanner.nextInt();

        ContaBancaria conta = new ContaBancaria(nrConta);

        while (true) {

            // Menu
            System.out.println("Banco Digital");
            System.out.println("1 - Depositar");
            System.out.println("2 - Levantar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Consultar movimentos");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o valor a depositar: ");
                    conta.depositar(scanner.nextDouble());
                    scanner.nextLine();
                }
                case 2 -> {
                    System.out.print("Digite o valor a levantar: ");
                    conta.levantar(scanner.nextDouble());
                    scanner.nextLine();
                }
                case 3 -> conta.consultarSaldo(nrConta);
                case 4 -> conta.consultarMovimentos(nrConta);
                case 0 -> {
                    System.out.println("Obrigada por utilizar a aplicação.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }

        }
    }

}
