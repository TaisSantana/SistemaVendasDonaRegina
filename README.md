# SistemaVendasDonaRegina
Atividade cadeira web3 IFPE


Escopo: Projeto Venda Dona Regina é um sistema para uma mercearia de bairro, pequeno porte, que
será utilizado para controlar o fiado de Dona Regina (a velha cadernetinha). Não é um sistema para
compra online, então o cliente não acessa o sistema, apenas a dona do estabelecimento.
Objetivo da atividade: Implementar alterações solicitadas no projeto Venda de Dona Regina e explicar as
alterações no Google Meet.
Alterações no projeto:
1. Na tela de Pesquisar produtos, incluir para cada produto um botão Venda Rápida (0,5)

2. Ao clicar no botão Venda Rápida deverá abrir uma tela para realizar venda com: (1,5)
a. Nome do produto selecionado
b. Quantidade do produto: caixa de texto
c. Cliente: lista com os clientes já cadastrados para selecionar um
d. Botão Registrar Venda

3. Ao clicar no botão Registrar Venda: (3,5)
a. Validar a quantidade de produtos: valor mínimo igual a 1
b. Calcular o valor total da venda : valor do produto multiplicado pela quantidade informada
c. Verificar se o cliente tem limite de crédito suficiente para a venda
d. Caso tenha limite de crédito suficiente, realizar duas ações:
i. inserir uma venda no banco de dados com (produto, quantidade, cliente, data de
realização da venda)
ii. atualizar o cliente com o limite de crédito deduzindo o valor vendido
e. Caso não tenha limite de crédito suficiente, exibir a mensagem "Crédito insuficiente"

4. Ao clicar no item no menu Vendas Realizadas: (2,0)
a. Exibir uma tela com a lista das vendas realizadas (nome do cliente, nome do produto, valor
total, data da realização da venda) ordenada pela data de realização.

5. Controle de Acesso: utilizando usuário único (usuário admin, senha adm123) para acessar o
sistema (2,5)
