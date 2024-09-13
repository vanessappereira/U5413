package Sessao2.ParteI;

import java.util.Scanner;

public class exercicios {

    public static void checkTime() {
        /*
         * Usando somente os operadores aritméticos estudados, crie um programa que
         * escreva as horas, minutos e segundos correspondentes a um determinado tempo
         * definido em segundos e introduzido pelo utilizador.
         */
        int seconds, hours, minutes, secondsLeft;

        Scanner s = new Scanner(System.in);
        System.out.println("Determinar o tempo \n" + "Insira o valor em segundos: ");
        seconds = s.nextInt();

        hours = seconds / 3600;
        minutes = (seconds % 3600) / 60;
        secondsLeft = seconds % 60;

        s.close();

        System.out.println(
                "O tempo inserido é: " + hours + " horas, " + minutes + " minutos e " + secondsLeft + " segundos");

    }

    public static String checkTriangle(int a, int b, int c) {
        /*
         * Crie um programa que leia os três lados de um triângulo e determine se este é
         * equilátero (todos os lados iguais), isósceles (dois lados iguais) ou escaleno
         * (todos os lados com cumprimentos diferentes).
         */
        String triangleType;

        if (a == b && b == c) {
            triangleType = "equilátero";
        } else if (a == b || b == c || a == c) {
            triangleType = "isósceles";
        } else {
            triangleType = "escaleno";
        }
        System.out.println("O triângulo é: " + triangleType);
        return triangleType;
    };

    public static void checkParkPayment(int hour) {
        /*
         * Crie um programa que leia a quantidade de horas que um carro ficou
         * estacionado e calcula o valor a pagar de acordo com o seguinte:
         * até 2 horas, 5 euros;
         * até 5 horas, 10 euros;
         * acima de 5 horas, 15 euros.
         */

        int payment;

        if (hour <= 2) {
            payment = 5;
        } else if (hour > 2 && hour <= 5) {
            payment = 10;
        } else if (hour > 5) {
            payment = 15;
        } else {
            payment = 0;
        }
        System.out.println("Tem o valor a pagar de " + payment + " euros");
    }

    public static void calcImposto(float salario) {
        /*
         * Um programa que leia o salário anual de colaborador e calcula a taxa * de
         * imposto que deve pagar, de acordo com o seguinte:
         * abaixo de 20.000 euros, isento;
         * entre 20.000 e 40.000 euros, 15%;
         * acima de 40.000 euros, 30%
         */
        float imposto, totalPagamento;

        if (salario < 20000) {
            imposto = 0;
        } else if (salario >= 20000 && salario < 40000) {
            imposto = salario * 0.15f;
        } else {
            imposto = salario * 0.30f;
        }

        totalPagamento = salario - imposto;
        System.out.println("\nO valor a pagar de imposto é: " + imposto + " euros" + "\n"
                + "O valor total a receber é: " + totalPagamento + "\n");
    }

    public static void main(String[] args) {
        // checkTime();
        // checkTriangle(5, 7, 2);
        // checkParkPayment(2);
        // calcImposto(60000);
    }
}
