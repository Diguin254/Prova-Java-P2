//-- produto definition 
//CREATE TABLE produto( 
//id SERIAL PRIMARY KEY, 
//nome text, 
//valor_unitario NUMERIC (10,2)
//); 
//-- bairro definition 
//CREATE TABLE bairro( 
//id SERIAL PRIMARY KEY, 
//nome text 
//); 
//
//-- login definition 
//CREATE TABLE login ( 
//id SERIAL PRIMARY KEY,
//password text,
//login_funcionario text
//); 
//
//-- cartao definition 
//CREATE TABLE cartao ( 
//id SERIAL PRIMARY KEY, 
//numeroCartao text, 
//cvv text, 
//tipoConta integer
//); 
//
//-- dinheiro definition 
//CREATE TABLE dinheiro ( 
//id SERIAL PRIMARY KEY, 
//valorEntregado NUMERIC (10,2) 
//); 
//
//-- cliente definition 
//CREATE TABLE cliente ( 
//id SERIAL PRIMARY KEY, 
//nome text
//); 
//
//-- status_pedido definition 
//CREATE TABLE statusPedido ( 
//id SERIAL PRIMARY KEY, 
//progresso text 
//);
//
//-- funcionario definition 
//CREATE TABLE funcionario ( 
//id SERIAL PRIMARY KEY, 
//nome text, 
//cpf text, 
//rg text,
//login_id integer,
//FOREIGN KEY (login_id) REFERENCES login(id) 
//); 
//
//-- met_pagamento definition 
//CREATE TABLE metodoPagamento( 
//id SERIAL PRIMARY KEY, 
//pix text, 
//dinheiro_id integer, 
//cartao_id integer, 
//FOREIGN KEY (dinheiro_id) REFERENCES dinheiro(id),
//FOREIGN KEY (cartao_id ) REFERENCES cartao(id) 
//); 
//
//-- endereco definition 
//CREATE TABLE endereco ( 
//id SERIAL PRIMARY KEY, 
//rua text,  
//cep text, 
//bairro_id integer, 
//distancia NUMERIC (10,2), 
//FOREIGN KEY (bairro_id) REFERENCES bairro(id) 
//); 
//
//-- cupom definition 
//CREATE TABLE cupom(  
//id SERIAL PRIMARY KEY, 
//valorCupom integer, 
//codigo text, 
//validade date
//); 
//
//-- telefone definition 
//CREATE TABLE telefone ( 
//id SERIAL PRIMARY KEY, 
//ddd text, 
//numero text,
//cliente_id integer,
//funcionario_id integer,
//FOREIGN KEY(cliente_id) REFERENCES cliente(id),
//FOREIGN KEY(funcionario_id) REFERENCES funcionario(id) 
//); 
//
//-- delivery definition 
//CREATE TABLE delivery ( 
//id SERIAL PRIMARY KEY, 
//chaveEntrega text, 
//numero integer, 
//complemento text,
//endereco_id integer, 
//FOREIGN KEY (endereco_id) REFERENCES endereco(id) 
//);
//
//-- pedido definition 
//CREATE TABLE pedido ( 
//id SERIAL PRIMARY KEY,
//horaPedido TIME, 
//numeroPedido integer,
//dataPedido date, 
//cliente_id integer, 
//status_pedido_id integer,
//FOREIGN KEY(cliente_id) REFERENCES cliente(id),
//FOREIGN KEY(status_pedido_id) REFERENCES statusPedido(id)
//);
//
//-- carrinho definition 
//CREATE TABLE carrinho( 
//id SERIAL PRIMARY KEY, 
//qntd integer, 
//pedido_id integer,
//produto_id integer,
//FOREIGN KEY (pedido_id) REFERENCES pedido(id), 
//FOREIGN KEY (produto_id) REFERENCES produto(id)
//); 
//
//-- ingrediente_escolha definition 
//CREATE TABLE ingredienteEscolha ( 
//id SERIAL PRIMARY KEY,
//carrinho_id integer, 
//FOREIGN KEY (carrinho_id) REFERENCES carrinho(id)
//);
//
//-- ingrediente_adicional definition 
//CREATE TABLE ingredienteAdicional( 
//id SERIAL PRIMARY KEY, 
//nome text, 
//valor NUMERIC (10,2),
//ingredienteEscolha_id integer, 
//FOREIGN KEY (ingredienteEscolha_id) REFERENCES ingredienteEscolha(id)
//);
//
//-- ingrediente_remover definition 
//CREATE TABLE ingredienteRemover ( 
//id SERIAL PRIMARY KEY, 
//nome text,
//ingredienteEscolha_id integer,
//FOREIGN KEY (ingredienteEscolha_id) REFERENCES ingredienteEscolha(id) 
//);
//
//-- entrega definition 
//CREATE TABLE entrega ( 
//id SERIAL PRIMARY KEY,
//cliente_id integer,
//tipoEntrega integer,
//delivery_id integer,
//pedido_id integer,
//status_pedido_id integer,
//FOREIGN KEY(cliente_id) REFERENCES cliente(id),
//FOREIGN KEY(delivery_id) REFERENCES delivery(id),
//FOREIGN KEY(pedido_id) REFERENCES pedido(id),
//FOREIGN KEY(status_pedido_id) REFERENCES statusPedido(id)
//);
//
//-- pagamento definition
//CREATE TABLE pagamento(  
//id SERIAL PRIMARY KEY,
//metodo_pagamento_id integer, 
//cupom_id integer, 
//pedido_id integer, 
//FOREIGN KEY (metodo_pagamento_id) REFERENCES metodoPagamento(id), 
//FOREIGN KEY (cupom_id) REFERENCES cupom (id), 
//FOREIGN KEY (pedido_id) REFERENCES pedido (id) 
//);  
//
//-- reembolso definition 
//CREATE TABLE reembolso ( 
//id SERIAL PRIMARY KEY, 
//motivo text, 
//pedido_id integer, 
//FOREIGN KEY (pedido_id) REFERENCES pedido(id) 
//);  
//
//CREATE TABLE taxaEntrega (
//id SERIAL PRIMARY KEY,
//taxa_entrega NUMERIC(10,2),
//endereco_id integer,
//FOREIGN KEY(endereco_id) REFERENCES endereco(id)
//);