package FinalProject;

import java.time.LocalDate;

public class Sandes extends Produto {

    private String tipoSandes; // mista, fiambre, queijo
    private String produtor;

    public Sandes(String nome, double price, LocalDate expiryDate, String reference) {
        super(nome, price, expiryDate, reference);
        this.tipoSandes = tipoSandes;
        this.produtor = produtor;
    }

}
