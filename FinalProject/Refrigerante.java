package FinalProject;

import java.time.LocalDate;

public class Refrigerante extends Produto {

    private boolean sugarFree;
    private String marca; // Pepsi, Sumol, Lipton

    public Refrigerante(String nome, double price, LocalDate expiryDate, String reference) {
        super(nome, price, expiryDate, reference);
        this.sugarFree = sugarFree;
        this.marca = marca;
    }
}
