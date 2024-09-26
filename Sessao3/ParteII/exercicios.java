package Sessao3.ParteII;

import java.util.Random;
import java.util.Scanner;

public class exercicios {
    /*
     * 1. Crie duas matrizes de 2x2 de inteiros. Carregue ambas com valores
     * introduzidos pelo utilizador. O programa deverá calcular, para cada posição
     * das matrizes, a respetiva multiplicação e mostrar o resultado.
     */
    public static void calcMatrizes() {
        Scanner scanner = new Scanner(System.in);

        // Criar as matrizes 2x2
        int[][] matriz1 = new int[2][2];
        int[][] matriz2 = new int[2][2];
        int[][] matrizResultado = new int[2][2];

        // Ler os valores das matrizes
        System.out.println("Digite os valores da primeira matriz:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matriz1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Digite os valores da segunda matriz:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matriz2[i][j] = scanner.nextInt();
            }
        }

        // Calcular a multiplicação elemento a elemento
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrizResultado[i][j] = matriz1[i][j] * matriz2[i][j];
            }
        }

        // Imprimir a matriz resultado
        System.out.println("Matriz resultado da multiplicação elemento a elemento:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrizResultado[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void calMatrizesRandom() {

        // Criar a matriz 2x2 e o objeto Random
        int[][] matriz = new int[2][2];
        Random random = new Random();

        // Preenchendo a matriz com valores aleatórios entre 1 e 60
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matriz[i][j] = random.nextInt(60) + 1;
            }
        }

        // Imprimir a matriz
        System.out.println("Matriz gerada aleatoriamente:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Calcular o determinante
        int determinante = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];

        // Imprimir o determinante
        System.out.println("Determinante da matriz: " + determinante);
    }


    public static void main(String[] args) {
        // calcMatrizes();
        calMatrizesRandom();
    }
}
