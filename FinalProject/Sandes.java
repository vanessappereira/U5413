package FinalProject;

import java.time.LocalDate;

public class Sandes extends Produto {

    private String tipoSandes; // mista, fiambre, queijo

    public Sandes(String nome, double preco, LocalDate dataExp, String referencia, String marca) {
        super(nome, preco, dataExp, referencia, marca);
        this.tipoSandes = tipoSandes;       

    }

 

}
