package FinalProject;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Produto implements Serializable {

    private String nome;
    private double preco;
    private String referencia;
    private LocalDate dataExp;
    private String marca;

    public Produto(String nome, double preco, LocalDate dataExp, String referencia, String marca) {
        this.nome = nome;
        this.preco = preco;
        this.dataExp = dataExp;
        this.referencia = referencia;
        this.marca = marca;
    }

    /* Getters e Setters */
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getReferencia() {
        return referencia;
    }

    public LocalDate getDataExp() {
        return dataExp;
    }

    public String getMarca() {
        return marca;
    }
}
