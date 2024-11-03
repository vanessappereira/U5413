package FinalProject;

import java.util.Objects;

public class Sandes extends Produto {

    public enum TipoSandes {
        MISTA, FIAMBRE, QUEIJO
    };

    private TipoSandes tipoSandes;

    public Sandes(String nome, double preco, String dataExp, String refBrand, String marca, TipoSandes tipoSandes) {
        super(nome, preco, dataExp, refBrand, marca);
        this.tipoSandes = tipoSandes;
    }

    /* Getters e Setters */
    public TipoSandes getTipoSandes() {
        return tipoSandes;
    }

    public void setTipoSandes(TipoSandes tipoSandes) {
        this.tipoSandes = tipoSandes;
    }

    @Override
    public String toString() {
        return String.format(
                "Chocolate: %s, Tipo de Cacau: %s, Preço: %.2f€, Marca: %s, Referência: %s, Data de Expiração: %s",
                getNome(), tipoSandes, getPreco(), getMarca(), getRefBrand(), getDataExp());
    }

    // Compare objects
    @Override
    public boolean equals(Object s) {
        if (this == s) {
            return true;
        }
        if (!(s instanceof Sandes)) {
            return false;
        }
        if (!super.equals(s)) {
            return false;
        }
        Sandes sandes = (Sandes) s;
        return tipoSandes == sandes.tipoSandes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoSandes);
    }

}
