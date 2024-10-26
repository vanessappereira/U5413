package Sessao9.Oficina;

public abstract class Veiculo {

    protected String modelo;
    protected static double velocidadeAtual;

    public Veiculo(String modelo, double velocidadeAtual) {
        this.modelo = modelo;
        this.velocidadeAtual = velocidadeAtual;
    }

    /* Setters e Getters */
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    //Mostrar velocidade atual
    public void mostrarVelocidadeAtual() {
        System.out.println("A velocidade atual do veículo é: " + velocidadeAtual + " km/h");
    }

    // Métodos Abstratos
    public abstract void acelerar(double velocidade);

    public abstract void travar(double reducao);

}
