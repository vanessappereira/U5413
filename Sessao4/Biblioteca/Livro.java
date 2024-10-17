package Sessao4.Biblioteca;

public class Livro {

    private String title, author;

    public Livro(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /* Setters */
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /* Getters */

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}
