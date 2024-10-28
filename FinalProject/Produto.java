package FinalProject;

import java.io.Serializable;

public abstract class Produto implements Serializable {

    private final String nome;
    private final double preco;
    private final String referencia;
    private final String dataExp;
    private final String marca;

    public Produto(String nome, double preco, String dataExp, String referencia, String marca) {
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

    public String getDataExp() {
        return dataExp;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public abstract String toString();
}
