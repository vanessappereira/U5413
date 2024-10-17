package Sessao5.ContaBancaria;

import java.util.Scanner;

public class ContaBancaria {

    //construtor
    public ContaBancaria(int nrconta) {
        this.nrconta = nrconta;
    }

    //atributos
    private int nrconta;
    private int nrmovimentos = 0;
    private double saldo = 0;
    private Scanner leitor = new Scanner(System.in);

    //métodos
    public int getNrconta() {
        return nrconta;
    }

    public void setNrconta(int nrconta) {
        this.nrconta = nrconta;
    }

    public int getNrmovimentos() {
        return nrmovimentos;
    }

    public void setNrmovimentos(int nrmovimentos) {
        this.nrmovimentos = nrmovimentos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private void verMsg(String txt) {
        System.out.print(txt);
    }

    public void fecharLeitor() {
        leitor.close();
    }

    public void depositar() {
        double montante;
        verMsg("\nDepositar:\n");
        do {
            verMsg("  Introduza o montante: ");
            montante = Double.parseDouble(leitor.nextLine());
            if (montante > 0) {
                saldo += montante;
                nrmovimentos++;
                verMsg("  Desposito Efetuado!");
            } else {
                verMsg("\n  Erro! Montante Inválido!\n");
            }
        } while (montante <= 0);
    }

    public void levantar() {
        double montante;
        verMsg("\nLevantar:\n");
        verMsg("  Introduza o montante: ");
        montante = Double.parseDouble(leitor.nextLine());

        if (saldo >= montante) {
            saldo -= montante;
            verMsg("  Levantamento Efetuado!");
            nrmovimentos++;
        } else {
            verMsg("\n  Erro! Saldo insuficiente!\n");
        }
    }

    public void consultarSaldo() {
        verMsg("\nSaldo: " + saldo + "eur");
    }

    public void consultarMovimento() {
        verMsg("\nN. de Movimentos: " + nrmovimentos);
    }
}
