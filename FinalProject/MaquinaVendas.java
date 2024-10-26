package FinalProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaquinaVendas implements Serializable {

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

    /* Adicionar Produto */
    public void adicionarProduto(Produto produto) {
        if (produto instanceof Chocolate && chocolates.size() < 20) {
            chocolates.add((Chocolate) produto);
        }
        if (produto instanceof Refrigerante && refrigerantes.size() < 15) {
            refrigerantes.add((Refrigerante) produto);
        }
        if (produto instanceof Sandes && sandwiches.size() < 10) {
            sandwiches.add((Sandes) produto);
        }
    }

    /* Vender Produto */
    public boolean venderProduto(String referencia, double valor) {
        Produto produto = procurarProduto(referencia);
        if (produto == null) {
            return false;
        }
        if (valor < produto.getpreco()) {
            return false;
        }
        removerProduto(produto);
        produtosVendidos.add(produto);
        totalVendas += produto.getpreco();
        return true;
    }

    private Produto procurarProduto(String reference) {
        // Procurar em todas as listas
        for (Produto p : chocolates) {
            if (p.getreferencia().equals(reference)) {
                return p;
            }
        }
        for (Produto p : refrigerantes) {
            if (p.getreferencia().equals(reference)) {
                return p;
            }
        }
        for (Produto p : sandwiches) {
            if (p.getreferencia().equals(reference)) {
                return p;
            }
        }
        return null;
    }

    private void removerProduto(Produto produto) {
        if (produto instanceof Chocolate) {
            chocolates.remove(produto);
        }
        if (produto instanceof Refrigerante) {
            refrigerantes.remove(produto);
        }
        if (produto instanceof Sandes) {
            sandwiches.remove(produto);
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("stock.dat"))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MaquinaVendas loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("stock.dat"))) {
            return (MaquinaVendas) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new MaquinaVendas();
        }
    }
}
