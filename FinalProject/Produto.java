package FinalProject;

import java.io.Serializable;

public abstract class Produto implements Serializable {
    private static final long serialVersionUID = 1L; // Added for serialization
    private final String nome;
    private final double preco;
    private final String refBrand;
    private final String dataExp;
    private final String marca;
    private int referencia;

    public Produto(String nome, double preco, String dataExp, String refBrand, String marca) {
        this.nome = nome;
        this.preco = preco;
        this.dataExp = dataExp;
        this.refBrand = refBrand;
        this.marca = marca;
        this.referencia = 0;
    }

    /* Getters e Setters */
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getRefBrand() {
        return refBrand;
    }

    public String getDataExp() {
        return dataExp;
    }

    public String getMarca() {
        return marca;
    }

    public void incrementReferencia() {
        this.referencia++;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia; // Update referencia first
        incrementReferencia(); // Then increment it
    }

    public String getReferencia() {
        return String.valueOf(this.referencia);
    }

    @Override
    public abstract String toString();
}
