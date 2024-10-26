package FinalProject;

import java.time.LocalDate;

public class Chocolate extends Produto {

    private String tipoCacau; // negro, branco, leite
    private String marca;

    public Chocolate(String nome, double preco, LocalDate dataExp, String referencia) {
        super(nome, preco, dataExp, referencia);
        this.tipoCacau = tipoCacau;
        this.marca = marca;
    }

}
