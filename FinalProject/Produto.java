package FinalProject;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Produto implements Serializable {

    private String nome;
    private double preco;
    private String referencia;
    private LocalDate dataExp;

    public Produto(String nome, double preco, LocalDate dataExp, String referencia) {
        this.nome = nome;
        this.preco = preco;
        this.dataExp = dataExp;
        this.referencia = referencia;
    }

    /* Getters e Setters */
    public String getnome() { return nome; }
    public double getpreco() { return preco; }
    public String getReferencia() { return referencia; }
    public LocalDate getdataExp() { return dataExp; }
    
}
