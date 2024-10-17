package Sessao5.ContaBancaria;

public class Teste {
    public static void main(String[] args){
        Cliente salgado = new Cliente("Ricardo", "912345678", "212121212");
        
        //adicionar contas
        salgado.adicionarConta();
        salgado.adicionarConta();
        salgado.adicionarConta();
        
        //listar contas
        salgado.listarContas();
        
        salgado.movimentarConta();
    }
}
