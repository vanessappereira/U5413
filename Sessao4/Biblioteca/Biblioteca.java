package Sessao4.Biblioteca;

import java.util.Scanner;

public class Biblioteca {

    // Declare variables 
    private static final int MAX_LIVROS = 3;
    private Livro[] livros;
    private int count; // Para acompanhar o número de livros adicionados

    public Biblioteca() {
        // Initializar o array
        livros = new Livro[MAX_LIVROS];
        // Inicializa a contagem de livros
        count = 0;
    }

    /* Setters e Getters */
    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public int getCount() {
        return count;
    }

    /* Adicionar livros à Biblioteca Livros com scanner */
    public void adicionarLivro(Scanner scanner) {
        String titulo, autor, res;
        if (count >= MAX_LIVROS) {
            System.out.println("Biblioteca está cheia!");
            return;
        }
        System.out.println("Digite o título do livro: ");
        titulo = scanner.nextLine();
        System.out.println("Digite o autor do livro: ");
        autor = scanner.nextLine();

        // Crie um novo livro com os dados fornecidos
        livros[count] = new Livro(titulo, autor);

        // Incrementa a contagem de livros
        count++;

        // Mensagem de sucesso
        System.out.println("Livro adicionado com sucesso. \nDeseja adicionar mais um? S/N");
        res = scanner.nextLine();
        if (res.equalsIgnoreCase("S")) {
            adicionarLivro(scanner);
        }

    }

    /* Listar os livros disponiveis na biblioteca  */
    public void listarLivros() {
        System.out.println("----------- Lista de Livros inseridos: -----------");
        for (int i = 0; i < MAX_LIVROS; i++) {
            if (livros[i] != null) {
                System.out.println("Título: " + livros[i].getTitle() + ", Autor: " + livros[i].getAuthor() + "\n");
            }
        }
        if (livros[0] == null) {
            System.out.println("A Biblioteca encontra se vazia.");
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("""
                --------- Menu Biblioteca ---------
                1. Adicionar Livros: 
                2. Listar Livros 
                0. Sair""");
            System.out.print("Escolha uma das opções: ");
            option = scanner.nextInt();
            scanner.nextLine(); /* Crucial line when switching diferent types of the input, after reading the integer with nextInt(), the scanner does not consume the newline character that is generated when the user presses Enter.This leftover newline can cause issues if the program subsequently tries to read a string input. */
            switch (option) {
                case 1 -> biblioteca.adicionarLivro(scanner);
                case 2 -> biblioteca.listarLivros();
                case 0 -> {
                    System.out.println("Obrigado por usar a Biblioteca!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
}
