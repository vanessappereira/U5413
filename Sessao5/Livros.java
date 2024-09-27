package Sessao5;

/*
    - Um construtor para inicializar os atributos.
    - Métodos get e set para os atributos.
    - Um método para mostrar as informações do livro.
 */
public class Livros {

    /* Atributes */
    private String titulo;
    private String autor;
    private double preco;

    public Livros(String autor, double preco, String titulo) {
        this.autor = autor;
        this.preco = preco;
        this.titulo = titulo;
    }

    /* Getters */
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    /* Setters */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    private void mostrarLivro() {
        System.out.println("Título: " + this.titulo + "\n"
                + "Autor: " + this.autor + "\n"
                + "Preço: " + this.preco + " EUR");
    }

    public static void main(String[] args) {
        // Criar 2 livros
        Livros livro1 = new Livros("J.K.Rowling", 20.0, "Harry Potter");
        Livros livro2 = new Livros("J.R.R.Tolkien", 30.0, "O Senhor dos Anéis");

        // Mostrar livros 
        livro1.mostrarLivro();
        livro2.mostrarLivro();
    }
}
