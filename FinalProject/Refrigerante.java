package FinalProject;

import java.util.Objects;

public class Refrigerante extends Produto {

    public enum TipoRefri {
        NORMAL, SUGARFREE
    };

    private TipoRefri tipoRefri;

    public Refrigerante(String nome, double preco, String dataExp, String referencia, String marca, TipoRefri tipoRefri) {
        super(nome, preco, dataExp, referencia, marca);
        this.tipoRefri = tipoRefri;
    }

    /* Getters e Setters */
    public TipoRefri getTipoRefri() {
        return tipoRefri;
    }

    public void setTipoRefri(TipoRefri tipoRefri) {
        this.tipoRefri = tipoRefri;
    }

    @Override
    public String toString() {
        return String.format("Refrigerante: %s, Tipo de bebida: %s, Preço: %.2f€, Marca: %s, Referência: %s, Data de Expiração: %s", getNome(), tipoRefri, getPreco(), getMarca(), getReferencia(), getDataExp());
    }

    @Override
    public boolean equals(Object r) {
        if (this == r) {
            return true;
        }
        if (!(r instanceof Chocolate)) {
            return false;
        }
        if (!super.equals(r)) {
            return false;
        }
        Refrigerante r1 = (Refrigerante) r;
        return tipoRefri == r1.tipoRefri;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipoRefri);        
    }

}
