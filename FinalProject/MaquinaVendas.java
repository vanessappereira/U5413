package FinalProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaquinaVendas implements Serializable {

    private static final int MAX_CHOCOLATES = 20;
    private static final int MAX_REFRIGERANTES = 15;
    private static final int MAX_SANDES = 10;

    private List<Chocolate> chocolates;
    private List<Refrigerante> refrigerantes;
    private List<Sandes> sandwiches;
    private List<Produto> produtosVendidos;
    private double totalVendas;

    public MaquinaVendas() {
        chocolates = new ArrayList<>();
        refrigerantes = new ArrayList<>();
        sandwiches = new ArrayList<>();
        produtosVendidos = new ArrayList<>();
        totalVendas = 0.0;
    }

}