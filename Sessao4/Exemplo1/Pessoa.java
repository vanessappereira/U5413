package Sessao4.Exemplo1;

public class Pessoa {

    /* Atributes */
    private String nome, estado;
    private int idade;
    private double altura;

    // Constructor
    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    //Getters
    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

}
