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
