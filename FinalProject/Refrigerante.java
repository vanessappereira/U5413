package FinalProject;

import java.time.LocalDate;

public class Refrigerante extends Produto {

    private boolean sugarFree;

    public Refrigerante(String nome, double preco, LocalDate dataExp, String referencia, String marca) {
        super(nome, preco, dataExp, referencia, marca);
        this.sugarFree = sugarFree;
    }


}
