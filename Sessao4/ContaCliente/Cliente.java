package Sessao4.ContaCliente;

import Sessao3.Parte3.ContaBancaria;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    public String name, phoneNumber, NIF;
    private static ArrayList<ContaBancaria> contas;

    // O Cliente poderá ter, em seu nome, diferentes contas bancárias.
    public Cliente(String name, String phoneNumber, String NIF, ContaBancaria contaBancaria) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.NIF = NIF;
        Cliente.contas = new ArrayList<>();
    }

    /* Getters e Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaBancaria> contas) {
        Cliente.contas = contas;
    }

    /* Adicionar Conta: é Solicitada ao utilizador as informações necessárias à abertura de uma conta, criada a mesma e adicionada à lista do cliente.*/
    public static void addContaBancaria(Cliente addCliente, int nrConta) {
        // Verificar se já existe ContaBancaria
        for (ContaBancaria conta : addCliente.getContas()) {
            if (conta.getNrConta() == nrConta) {
                System.out.println("A conta já existe.");
                return;
            }
            // Create a new bank account on the Client
            ContaBancaria newConta = new ContaBancaria(nrConta);
            addCliente.getContas().add(newConta);
            System.out.println("Conta criada com sucesso!");
            return;
        }
    }

    /* Eliminar Conta: O utilizador digita o número da conta, é feita uma pesquisa entre as contas existentes na lista e, havendo, a mesma é eliminada. Caso contrário, informado de que a mesma não existe.*/
    public static void removeContaBancaria(Cliente addCliente, int nrConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNrConta() == nrConta) {
                contas.remove(conta);
                System.out.println("Conta eliminada com sucesso!");
                return;
            } else {
                System.out.println("Conta não encontrada!");
                return;
            }
        }
    }

    /*  Movimentar a Conta (Para efetuar qualquer operação, levantar, depositar, etc.): O utilizador digita o número da conta, é feita uma pesquisa entre as contas existentes na lista e, havendo, a solicitada a operação desejada a realizar nessa conta. Caso a opção ou número de conta não exista, informa-se o utilizador e volta-se ao menu principal.*/
    public static void movimentarContaBancaria(int numeroConta, int operacao, Scanner scanner) {
        for (ContaBancaria conta : contas) {
            if (conta.getNrConta() == numeroConta) {
                switch (operacao) {
                    case 1 -> {
                        System.out.print("Digite o valor a depositar: ");
                        conta.depositar(scanner.nextDouble());
                        scanner.nextLine();
                    }
                    case 2 -> {
                        System.out.print("Digite o valor a levantar: ");
                        conta.levantar(scanner.nextDouble());
                        scanner.nextLine();
                    }
                    default -> {
                        System.out.println("Operação inválida!");
                        return;
                    }
                }
            } else {
                System.out.println("Conta não encontrada!");
                return;
            }
        }
    }

    /* Listar Contas: Mostra todas as contas (Apenas número e saldo) de todas as contas que, naquele momento, estejam associadas ao Cliente. */
    public static void listarContas() {
        for (ContaBancaria conta : contas) {
            System.out.println("Número da Conta: " + conta.getNrConta() + " Saldo:" + conta.getSaldo());
        }
    }

    // Menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Criar Cliente
        Cliente clientenvo = new Cliente("Vanessa", "123456789", "222222222", null);

        while (true) {

            // Menu
            System.out.println("Cliente Banco Digital");
            System.out.println("1 - Adicionar Conta");
            System.out.println("2 - Eliminar Conta");
            System.out.println("3 - Movimentar Conta");
            System.out.println("4 - Listar Contas");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            //solicitar nr de conta:
            System.out.print("Digite o número da conta: ");
            int nrConta = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    addContaBancaria(clientenvo, nrConta);
                case 2:
                    removeContaBancaria(clientenvo, nrConta);
                case 3:
                    System.out.println("Selecione uma das seguintes opções: \n1. Depositar\n2.Levantar");
                    int opcao2 = scanner.nextInt();
                    movimentarContaBancaria(nrConta, opcao2, scanner);
                    scanner.nextLine();
                case 4:
                    listarContas();
                case 0: {
                    System.out.println("Obrigada por utilizar a aplicação.");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
