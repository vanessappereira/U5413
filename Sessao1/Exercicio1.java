package Sessao1;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        int idade = 20;
        String nome = "João";
        double altura = 1.80;
        boolean estaTrabalhando = false;
        char sexo = 'M';
        System.out.println("Hellooooooo");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Sexo: " + sexo);
        System.out.println("A trabalhar? " + estaTrabalhando);

        Scanner k = new Scanner(System.in);
        System.out.println("Insira um Nome:");
        String name2 = k.nextLine();
        System.out.println("Insira uma Idade:");
        int idade2 = k.nextInt();

        k.close();

        System.out.println("Chamas te " + name2 + " e tens " + idade2 + " anos.");
    }

}