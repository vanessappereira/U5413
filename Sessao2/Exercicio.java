package Sessao2;

import java.util.Scanner;

public class Exercicio {

    public static void main(String[] args) {
        String a;
        String b;
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Insira 2 Strings:");
            a = s.nextLine();
            b = s.nextLine();
        }

        // Compare Strings
        System.out.println("Compare Strings: " + a.equals(b));

        int codigo = 2;

        String cor;

        switch (codigo) {
            case 1 -> {
                cor = "Vermelho";
                System.out.println(cor);
            }
            case 2 -> {
                cor = "Azul";
                System.out.println(cor);
            }
            default -> {
                cor = "Preto";
                System.out.println(cor);
            }
        }
    }
}