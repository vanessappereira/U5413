
# Simulação de uma Máquina de Venda Automática de Snacks

## Neste exercício pretende-se que desenvolva uma aplicação que simule uma máquina de venda automática de snacks. A máquina deve ter a capacidade de vender diversos tipos de produtos: chocolates, refrigerantes e sandes. Cada produto é caracterizado por um nome, um preço, uma referência e um prazo de validade

## Entregar código fonte e respetivo diagrama de classes

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


[Product] <|-- [Chocolate]
[Product] <|-- [Beverage]
[Product] <|-- [Sandwich]
[VendingMachine] --> [Product]
[VendingMachineApp] --> [VendingMachine]