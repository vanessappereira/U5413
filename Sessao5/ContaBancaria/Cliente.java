package Sessao5.ContaBancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    //construtores
    public Cliente(String nome, String telefone, String nif) {
        this.nome = nome;
        this.telefone = telefone;
        this.nif = nif;
    }
    
    //atributos
    private Scanner leitor = new Scanner(System.in);
    private int nrconta = 1; //usado para sequenciar nr da conta
    private String nome;
    private String telefone;
    private String nif;
    private ArrayList<ContaBancaria> contas = new ArrayList<>();
    
    //métodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
    }
    
    public void adicionarConta(){
        contas.add(new ContaBancaria(nrconta));
        nrconta++;
    }
    
    public void listarContas(){
        System.out.println("\nDados das Contas ---------\n");
        for(int i=0; i<contas.size(); i++){
            System.out.println("Nr.: " + contas.get(i).getNrconta());
            System.out.println("Saldo: " + contas.get(i).getSaldo() + "\n");
        }
    }
    
    //pesquisar conta
    private ContaBancaria pesquisarConta(){
        ContaBancaria contaTemp = null;
        int nr;
        
        System.out.println("\nPesquisar Conta --------");
        System.out.print("Introduza o nr da conta: ");
        nr = Integer.parseInt(leitor.nextLine());
        
        //pesquisar pelo nr entre as contas existentes no momento
        for(int i=0; i<contas.size(); i++){
            //compara nr com o número da conta atual
            if(contas.get(i).getNrconta() == nr){
                contaTemp = contas.get(i);
                break;
            }
        }
        
        return contaTemp;
    }
    
    //movimentar conta
    public void movimentarConta(){
        ContaBancaria contaTemp = pesquisarConta();
        
        if(contaTemp != null){
            //conta encontrada
            contaTemp.depositar();
        }else{
            //conta não encontrada
        }
    }
}
