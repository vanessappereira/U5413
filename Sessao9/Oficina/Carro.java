package Sessao9.Oficina;

public class Carro extends Veiculo {

    public Carro(String modelo) {
        super(modelo, velocidadeAtual);
    }  

    @Override
    public void acelerar(double velocidade) {
        velocidadeAtual += velocidade;
    }

    @Override
    public void travar(double reducao) {
        velocidadeAtual = Math.max(0, velocidadeAtual - reducao);
    }

}
