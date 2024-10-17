package Sessao3.Parte1;

import java.util.Scanner;

public class exercicios {

    // Declarar vectores de 5 e 10 - para que estes vetores possam ser
    // acedidos/partilhados nas funções das classes, terá de ser estático
    static int[] vetor5 = new int[5];
    static int[] vetor10 = new int[10];

    private static void declareVector(Scanner scanner) {
        System.out.println("1. Vetor de 5");
        System.out.println("2. Vetor de 10");
        System.out.println("0. Menu anterior");
        int vectorOption = scanner.nextInt();

        switch (vectorOption) {
            case 1 ->
                declareVector5(scanner);
            case 2 ->
                declareVector10(scanner);
            case 0 -> {
                // volta para o menu anterior
                System.out.println("Voltando para o menu anterior");
                return;
            }
            default ->
                System.out.println("Opção inválida");
        }
    }

    private static boolean existeNumero(int[] vetor, int numero) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                return true;
            }
        }
        return false;
    }

    private static void declareVector5(Scanner scanner) {
        // vetor de 5
        System.out.println("Por favor digite 5 números ");
        int numero;
        for (int i = 0; i < 5; i++) {
            boolean existe = true;
            while (existe) {
                numero = scanner.nextInt();
                if (existeNumero(vetor5, numero)) {
                    // mostrando a posição em que foi encontrado
                    System.out.println("O número " + numero + " já existe na posição " + i);
                } else {
                    existe = false;
                }
                vetor5[i] = numero;
            }
        }

        // Realizar a soma
        int soma = 0;
        for (int i = 0; i < 5; i++) {
            soma += vetor5[i];
        }
        System.out.println("Ex1- A soma dos números do vetor de 5 é: " + soma);
    }

    private static void declareVector10(Scanner scanner) {
        // vetor de 10
        System.out.println("Por favor digite 10 números ");
        int numero;
        for (int i = 0; i < vetor10.length; i++) {
            boolean existe = true;
            while (existe) {
                numero = scanner.nextInt();
                if (existeNumero(vetor5, numero)) {
                    // mostrando a posição em que foi encontrado
                    System.out.println("O número " + numero + " já existe na posição " + i);
                } else {
                    existe = false;
                }
            }
            // Verificar o menor e o mair número
            int menor = vetor10[0];
            int maior = vetor10[0];

            for (int j = 0; j < vetor10.length; j++) {
                if (vetor10[j] < menor) {
                    menor = vetor10[j];
                }
                if (vetor10[j] > maior) {
                    maior = vetor10[j];
                }
            }
            System.out.println("Ex2- Vetor de 10\nMenor número: " + menor + "\nMaior número: " + maior);
        }
    }

    private static void viewVectors(Scanner scanner) {
        System.out.println("1. Ver lista vetor 5\n2. Ver lista vetor 10");
        System.out.println("0. Menu anterior");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                // ver data do vetor 5
                if (vetor5 != null && vetor5.length > 0) {
                    System.out.println("Vetor 5:");
                    for (int i = 0; i < vetor5.length; i++) {
                        System.out.println("id: " + (i + 1) + " Número: " + vetor5[i]);
                    }
                } else {
                    System.out.println("O vetor 5 está vazio.");
                }
            }
            case 2 -> {
                // ver data do vetor 10
                if (vetor10 != null && vetor10.length > 0) {
                    System.out.println("Vetor 10:");
                    for (int j = 0; j < vetor10.length; j++) {
                        System.out.println("id: " + (j + 1) + ":" + vetor10[j]);
                    }
                } else {
                    System.out.println("O vetor 10 está vazio.");
                }
            }
            case 0 -> {
                // volta para o menu anterior
                System.out.println("Voltando para o menu anterior");
                return;
            }
            default ->
                System.out.println("Opção inválida");
        }
    }

    private static void searchNumber(Scanner scanner) {
        System.out.println("Digite o número a procurar: ");
        int number = scanner.nextInt();

        // Search in vetor5 first
        int indexInVetor5 = findNumberInArray(vetor5, number);
        if (indexInVetor5 != -1) {
            System.out.println("O número foi encontrado no vetor5 na posição " + indexInVetor5);
        } else {
            // If not found in vetor5, search in vetor10
            int indexInVetor10 = findNumberInArray(vetor10, number);
            if (indexInVetor10 != -1) {
                System.out.println("O número foi encontrado no vetor10 na posição " + indexInVetor10);
            } else {
                System.out.println("O número não foi encontrado.");
            }
        }
    }

    private static int findNumberInArray(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        // Inicialização de variáveis
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("============ Menu ============");
            System.out.println("1. Declarar vetor \n2. Ver vetores\n3. Procurar número\n0. Sair");
            System.out.println("===============================");
            System.out.print("Por favor escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    declareVector(scanner);
                    break;
                case 2:
                    viewVectors(scanner);
                    break;
                case 3:
                    searchNumber(scanner);
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o nosso programa!");
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
