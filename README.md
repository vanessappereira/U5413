# 5413 - Programação de Computadores - Orientada a Objetos

Este repositório contém uma coleção de exercícios práticos de programação orientada a objetos, abordando conceitos fundamentais através de diversos programas em linguagem de programação.

## Índice

- [Ficha 1](#ficha-1)
  - [Parte I - Exercícios Iniciais](#parte-i---exercícios-iniciais)
  - [Parte II - Exercícios Avançados](#parte-ii---exercícios-avançados)
- [Ficha 2](#ficha-2)
  - [Parte I - Vetores](#parte-i---vetores)
  - [Parte II - Matrizes](#parte-ii---matrizes)
- [Ficha 3](#ficha-3)
  - [1. Classe Retangulo](#1-classe-retangulo)
  - [2. Classe Livro](#2-classe-livro)
  - [3. Classe ContaBancaria](#3-classe-contabancaria)
- [Ficha 4](#ficha-4)
  - [1. Classe Livro e Biblioteca](#1-classe-livro-e-biblioteca)
  - [2. Classe Cliente e ContaBancaria](#2-classe-cliente-e-contabancaria)
- [Ficha 5](#ficha-5)
  - [Sistema de Cálculo de Salários](#sistema-de-cálculo-de-salários)
- [Projeto Final: Simulação de uma Máquina de Venda Automática de Snacks](#projeto-final)

## Ficha 1

### Parte I - Exercícios Iniciais

1. **Conversão de Tempo**: Crie um programa que converta um tempo em segundos, introduzido pelo utilizador, para horas, minutos e segundos.
2. **Classificação de Triângulos**: Desenvolva um programa que leia os três lados de um triângulo e determine se é equilátero, isósceles ou escaleno.
3. **Cálculo de Estacionamento**: Escreva um programa que calcule o valor a pagar por horas de estacionamento:
   - Até 2 horas: 5 euros
   - Até 5 horas: 10 euros
   - Acima de 5 horas: 15 euros
4. **Cálculo de Imposto**: Crie um programa que leia o salário anual de um colaborador e calcule a taxa de imposto a pagar:
   - Abaixo de 20.000 euros: isento
   - Entre 20.000 e 40.000 euros: 15%
   - Acima de 40.000 euros: 30%

### Parte II - Exercícios Avançados

1. **Soma de Números Pares**: Escreva um programa que leia um número N e mostre a soma de todos os números pares entre 1 e N.
2. **Números Ímpares**: Crie um programa que leia um número N e mostre todos os números ímpares de 1 até N.
3. **Tabuada**: Desenvolva um programa que leia um número N e mostre a tabuada para cada valor entre 1 e N.
4. **Números Perfeitos**: Mostre todos os números perfeitos entre 1 e um valor introduzido pelo utilizador. (Um número perfeito é aquele cuja soma de seus divisores próprios é igual ao próprio número).
5. **Triângulo de Números**: Imprima as primeiras N linhas de um triângulo, onde cada linha contém números consecutivos. Por exemplo, se N=5, a saída será um triângulo com 5 linhas.
6. **Idades de Pessoas**: Leia a idade de um número indeterminado de pessoas, calculando a média, a menor e a maior idade, terminando a leitura quando a idade 0 for inserida.
7. **Simulação de Enchimento de Depósito**: Simule o enchimento de um depósito com uma capacidade definida pelo utilizador, usando baldes de capacidade também definida pelo utilizador.

## Ficha 2

### Parte I - Vetores

1. **Soma de Elementos**: Declare um vetor de 5 números inteiros, leia os valores do utilizador e mostre a soma dos elementos.
2. **Maior e Menor Valor**: Declare um vetor de 10 inteiros, leia os valores e mostre o maior e o menor.
3. **Verificação de Números**: Armazene 10 números inteiros em um vetor e verifique se um número fornecido pelo utilizador existe no vetor, mostrando sua posição ou uma mensagem de erro.
4. **Valores Únicos**: Leia 10 números inteiros, garantindo que não haja duplicatas, solicitando novas entradas quando necessário.

### Parte II - Matrizes

1. **Multiplicação de Matrizes**: Crie duas matrizes 2x2, carregue com valores do utilizador e mostre o resultado da multiplicação de cada posição.
2. **Determinante de Matriz**: Preencha uma matriz 2x2 com valores aleatórios entre 1 e 60, mostre os valores e calcule o determinante.

## Ficha 3

### 1. Classe Retangulo

Crie uma classe chamada `Retangulo` que tenha os seguintes atributos:

- `largura` (double)
- `altura` (double)

Implemente os seguintes métodos:

- **Definir e Obter Valores**: Métodos para definir e obter os valores da largura e altura.
- **Calcular Área**: Um método que calcula e retorna a área do retângulo.
- **Calcular Perímetro**: Um método que calcula e retorna o perímetro do retângulo.

No método `main`, crie uma instância da classe `Retangulo`, defina os valores para a largura e altura, e exiba a área e o perímetro no console.

### 2. Classe Livro

Crie uma classe chamada `Livro` com os seguintes atributos:

- `titulo` (String)
- `autor` (String)
- `preco` (double)

Implemente os seguintes métodos:

- **Construtor**: Um construtor que inicializa os atributos.
- **Métodos Get e Set**: Métodos para obter e definir os valores dos atributos.
- **Mostrar Informações**: Um método que exibe as informações do livro.

No método `main`, crie duas instâncias da classe `Livro` e mostre suas informações no console.

### 3. Classe ContaBancaria

Crie uma classe chamada `ContaBancaria` com os seguintes atributos:

- `numeroConta` (int)
- `saldo` (double) - inicia sempre em zero
- `nrmovimentos` (int) - inicia sempre em zero

Implemente os seguintes métodos:

- **Depositar**: Um método que permite ao usuário depositar um valor na conta.
- **Contabilizar Movimentos**: Um método que contabiliza o total de movimentos (depósitos e levantamentos) realizados.
- **Mostrar Total de Movimentos**: Um método que exibe o total de movimentos efetuados.
- **Levantar**: Um método que permite ao usuário levantar um valor da conta, garantindo que o saldo nunca fique negativo.
- **Mostrar Saldo**: Um método que exibe o saldo atual da conta.

No método `main`, crie uma instância da `ContaBancaria` e implemente um menu para gerenciar a conta com as seguintes opções:

1. Depositar
2. Levantar
3. Consultar Saldo
4. Consultar Total de Movimentos
5. Sair

#### Funcionalidades do Menu

- **Depositar**: Solicite ao usuário o montante a ser depositado. O valor não pode ser negativo; caso seja, exiba uma mensagem de erro e peça um novo montante. Se o depósito for realizado com sucesso, contabilize o movimento.
- **Levantar**: Solicite ao usuário o montante a ser levantado. Se houver saldo suficiente, debite o valor da conta. Caso contrário, informe ao usuário que o movimento não é autorizado. Se o levantamento for realizado com sucesso, contabilize o movimento.

- **Consultar Saldo**: Exiba no console o saldo atual da conta.

- **Consultar Total de Movimentos**: Exiba no console o total de movimentos realizados.

- **Opção Inválida**: Caso o usuário insira uma opção inválida (diferente de 0, 1, 2, 3 ou 4), informe que a opção é inválida e solicite uma nova entrada.

## Ficha 4

### 1. Classe Livro e Biblioteca

- **Classe Livro**:

  - **Atributos**:
    - `titulo` (String)
    - `autor` (String)
  - **Métodos**:
    - Getters e Setters para os atributos.

- **Classe Biblioteca**:

  - **Atributos**:
    - `livros` (`ArrayList<Livro>` ou array de 3 livros)
  - **Métodos**:
  - **Adicionar Livro**: Método para adicionar livros, garantindo que não sejam adicionados mais do que três.
  - **Listar Livros**: Método para listar todos os livros presentes na biblioteca.

- **Implementação**:
  - No programa principal, utilize a classe `Scanner` para permitir que o utilizador adicione até 3 livros à biblioteca, inserindo o título e o autor. Após a adição, mostre todos os livros disponíveis na biblioteca.

### 2. Classe Cliente e ContaBancaria

- **Classe Cliente**:

  - **Atributos**:
    - `nome` (String)
    - `telefone` (String)
    - `NIF` (String)
    - `contas` (`ArrayList<ContaBancaria>`)
  - **Métodos**:
    - **Adicionar Conta**: Solicita ao utilizador as informações necessárias para abrir uma conta e adiciona à lista de contas do cliente.
    - **Eliminar Conta**: Permite ao utilizador digitar o número da conta e, se existir, elimina a conta. Caso contrário, informa que a conta não existe.
    - **Movimentar Conta**: Permite ao utilizador realizar operações (levantar, depositar, etc.) em uma conta existente, informando se a conta ou a opção não existe.
    - **Listar Contas**: Mostra todas as contas associadas ao cliente, exibindo apenas o número e o saldo.
    - **Sair**: Termina o programa.

- **Implementação**:
  - No programa principal, implemente um menu que permita ao utilizador interagir com as contas bancárias, utilizando as funcionalidades descritas acima. ```markdown

## Ficha 5

### Sistema de Cálculo de Salários

Desenvolver um sistema que calcule os salários dos funcionários de uma empresa, considerando diferentes categorias de funcionários e suas respectivas regras de cálculo.

### Atributos Comuns dos Funcionários

Todos os funcionários devem ter os seguintes atributos:

- **Nome** (String): Nome completo do funcionário.
- **Email** (String): Endereço de e-mail do funcionário.
- **Departamento** (Departamento): O departamento onde o funcionário está alocado.
- **Salário** (double): O salário base do funcionário.

### Método de Cálculo de Salário

Cada funcionário deve implementar um método chamado `calcularSalarioTotal()`, que retorna o salário líquido, após a dedução de 11% de contribuição social.

### Regras Específicas para Categorias de Funcionários

1. **Gerentes**:

   - Recebem uma bonificação que é adicionada integralmente ao salário líquido.
   - A classe `Gerente` deve chamar o construtor da superclasse e inicializar a bonificação.
   - O método `calcularSalarioTotal()` deve ser sobrescrito para incluir a bonificação.

2. **Programadores**:
   - Recebem um bônus que é sujeito à mesma taxa de contribuição social de 11%.
   - A classe `Programador` deve seguir o mesmo padrão da classe `Gerente`, utilizando o construtor da superclasse e sobrescrevendo o método `calcularSalarioTotal()` para incluir o valor líquido do bônus.

### Estrutura da Empresa

A empresa possui:

- 2 Gerentes
- 4 Programadores

### Implementação do Sistema

- Criar uma lista para armazenar todos os funcionários (Gerentes e Programadores).
- Percorrer essa lista para exibir:
  - Os nomes de todos os funcionários.
  - O total a ser pago em salários líquidos.

### Exibição dos Resultados

O sistema deve apresentar uma lista com os nomes de todos os funcionários, junto com o valor total a ser pago pelos seus salários líquidos.

## Projeto Final

### Simulação de uma Máquina de Venda Automática de Snacks

## Neste exercício pretende-se que desenvolva uma aplicação que simule uma máquina de venda automática de snacks. A máquina deve ter a capacidade de vender diversos tipos de produtos: chocolates, refrigerantes e sandes. Cada produto é caracterizado por um nome, um preço, uma referência e um prazo de validade

### A máquina possui as seguintes capacidades

- 20 Chocolates
- 15 refrigerantes
- 10 sandes

### Cada tipo de produto deve ter características específicas

- Chocolates: Cada chocolate deve ter um tipo de cacau (negro, branco ou leite) e uma marca associada.
- Refrigerantes: Os refrigerantes podem ser normais ou sem açúcar e têm associada uma marca (Pepsi, Sumol ou Lipton).
- Sandes: As sandes podem ser mistas, de fiambre ou queijo e possuem o nome do produtor associado.

## Processo de Venda

### A máquina deve ter a capacidade de realizar as seguintes operações

1. O cliente introduz um montante.
2. O cliente seleciona o tipo de produto desejado (chocolate, refrigerante ou sandes). Deve ser apresentada uma lista com todos os produtos disponíveis nessa categoria. Se não existirem produtos em stock, deve ser apresentada uma mensagem informativa.
3. O cliente escolhe um produto através da referência. Se o montante introduzido for insuficiente, deve ser apresentada uma mensagem de erro indicando a diferença a ser paga. Caso contrário, o produto é entregue, e, se aplicável, o troco é devolvido. O cliente deve ter a opção de cancelar a compra se não tiver mais dinheiro.
4. Após uma venda bem-sucedida, o stock do produto deve ser decrementado.

## Gestão da máquina

### Um colaborador deve poder

- Adicionar novos produtos a cada uma das categorias.
- Retirar produtos da máquina.
- Consultar o valor total resultante de todas as vendas até ao momento.
- Visualizar um histórico com todos os produtos vendidos, incluindo o nome do produto e o preço. Este histórico deve poder ser limpo a qualquer momento.

> A aplicação deve ser desenvolvida com foco na utilização dos conceitos de programação orientada a objetos, garantindo que a estrutura do código seja flexível e mantenha a capacidade de expansão para futuras funcionalidades.
> As funcionalidades são acedidas através de um menu de texto. Já os dados. deverão ser guardados de forma permanente num ficheiro chamado stock.dat e carregados automaticamente sempre que a máquina for ligada. Proceda ao tratamento das possíveis exceções.
