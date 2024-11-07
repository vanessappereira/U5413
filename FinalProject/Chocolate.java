package FinalProject;

import java.util.Objects;

public class Chocolate extends Produto {

    public enum TipoCacau {
        BRANCO, LEITE, NEGRO
    }

    private TipoCacau tipoCacau;

    public Chocolate(String nome, double preco, String dataExp, String refBrand, String marca, TipoCacau tipoCacau) {
        super(nome, preco, dataExp, refBrand, marca);
        this.tipoCacau = tipoCacau;
    }

    /* Getters e Setters */
    public TipoCacau getTipoCacau() {
        return tipoCacau;
    }

    public void setTipoCacau(TipoCacau tipoCacau) {
        this.tipoCacau = tipoCacau;
    }

    @Override
    public String toString() {
        return String.format(
                "%s - %s, Tipo de Cacau: %s, Preço: %.2f€, Marca: %s, Referência: %s, Data de Expiração: %s",
                getReferencia(), getNome(), tipoCacau, getPreco(), getMarca(), getRefBrand(), getDataExp());
    }

    // Compare objects
    @Override
    public boolean equals(Object c) {
        if (this == c) {
            return true;
        }
        if (!(c instanceof Chocolate)) {
            return false;
        }
        if (!super.equals(c)) {
            return false;
        }
        Chocolate chocolate = (Chocolate) c;
        return tipoCacau == chocolate.tipoCacau;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoCacau);
    }
}
