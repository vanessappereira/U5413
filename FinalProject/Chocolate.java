package FinalProject;

import java.time.LocalDate;
import java.util.List;

public class Chocolate extends Produto {

    private String tipoCacau; // negro, branco, leite

    public Chocolate(String nome, double preco, LocalDate dataExp, String referencia, String marca, String tipoCacau) {
        super(nome, preco, dataExp, referencia, marca);
        this.tipoCacau = tipoCacau;
    }

}
