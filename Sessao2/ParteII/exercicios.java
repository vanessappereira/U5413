package Sessao2.ParteII;

import java.util.Scanner;

public class exercicios {
    public static void sumEven(int n) {
        /*
         * Escreva um programa que leia um número N, calcule e mostre a soma de todos os
         * números pares entre 1 e N.
         */
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                soma += i;
            }
        }
        System.out.println("A soma total de numeros pares com o N de " + n + " é: " + soma);
    }

    public static void sumOdd(int n) {
        /*
         * Escreva um programa que leia um número N, calcule e mostre a soma de todos os
         * números impares entre 1 e N.
         */
        int soma = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                soma += i;
            }
        }
        System.out.println("A soma total de numeros impares com o N de " + n + " é: " + soma);
    }

    public static void tabuada(int n) {
        /*
         * Escreva um programa que leia um número N e mostre, para cada valor entre 1 e
         * N, a respetiva tabuada até 10.
         */
        for (int i = 1; i <= 10; i++) {
            // Multiplica por n
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    public static void perfectNumbers(int n) {
        /*
         * Mostre todos os números perfeitos entre 1 e o valor introduzido pelo
         * utilizador.
         */
        for (int i = 1; i <= n; i++) {
            int soma = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    soma += j;
                }
            }
            if (soma == i) {
                System.out.println("O número " + i + " é um número perfeito");
            }
        }
    }

    public static void numericTriangle(int n) {
        /*
         * Um programa que mostre as primeiras N linhas de um triângulo.
         * Isto é, dado um número inteiro positivo N, imprima N linhas.
         */
        int numero = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(numero + " ");
                numero++;
            }
            System.out.println();
        }
    }

    public static void mediaIdades() {
        /*
         * Para um número indeterminado de pessoas: leia a idade de cada uma, sendo que
         * a idade 0 (zero) indica o fim da leitura e não deve ser considerada. A
         * seguir, calcule o número de pessoas; a idade média do grupo; a menor idade e
         * a maior idade.
         */
        Scanner s = new Scanner(System.in);

        int idade = 0, somaIdades = 0, cont = 0, menorIdade = Integer.MAX_VALUE,
                maiorIdade = Integer.MIN_VALUE;

        System.out.println("Digite as idades (0 para terminar): ");

        while ((idade = s.nextInt()) != 0) {
            cont++;
            somaIdades += idade;

            // Atualiza a maior e a menor idade
            if (idade < menorIdade) {
                menorIdade = idade;
            }
            if (idade > maiorIdade) {
                maiorIdade = idade;
            }
        }
        // Calcula a média das idades
        if (cont > 0) {
            double mediaIdades = (double) somaIdades / cont;

            System.out.println("Número de idades submetidas: " + cont + "\nMédia das idades: " + mediaIdades
                    + "\nMenor idade: " + menorIdade + "\nMaior idade: " + maiorIdade);
        } else {
            System.out.println("Nenhuma idade foi submetida");
        }
        s.close();
    }

    public static void encherDeposito() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Capacidade total do depósito (litros): ");
        double capacidadeTotal = scanner.nextDouble();

        System.out.print("Capacidade do balde (litros): ");
        double capacidadeBalde = scanner.nextDouble();

        scanner.close();

        int balde = 1;
        double liquidoRestante = capacidadeTotal;

        while (liquidoRestante > 0) {
            double quantidadeAdicionar;
            
            if (capacidadeBalde < liquidoRestante) {
                quantidadeAdicionar = capacidadeBalde;
            } else {
                quantidadeAdicionar = liquidoRestante;
            }
            
            System.out.println("Enchendo balde " + balde + " com " + quantidadeAdicionar + " litros");
            liquidoRestante -= quantidadeAdicionar;
            balde++;
        }

        if (liquidoRestante == 0) {
            System.out.println("Depósito preenchido completamente.");
        } else {
            System.out.println("Sobrou " + Math.abs(liquidoRestante) + " litros no depósito.");
        }

    }

    public static void main(String[] args) {
        // sumEven(10);
        // sumOdd(10);
        // tabuada(76);
        // perfectNumbers(6);
        // numericTriangle(5);
        // mediaIdades();
        encherDeposito();
    }
}
