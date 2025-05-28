/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancoConexao;

/**
 *
 * @author Cliente
 */
public class teste {
    
//    -- produto definition 
//CREATE TABLE produto( 
//id integer not null primary key autoincrement, 
//nome text, 
//valor_unitario NUMERIC (2,2)
//); 
//-- ingrediente_adicional definition 
//CREATE TABLE ingredienteAdicional( 
//id integer not null primary key autoincrement, 
//nome text, 
//valor NUMERIC (2,2),
//ingredienteEscolha_id integer, 
//FOREIGN KEY (ingredienteEscolha_id) REFERENCES ingredienteEscolha(id)
//);
// 
//-- ingrediente_remover definition 
//CREATE TABLE ingredienteRemover ( 
//id integer not null primary key autoincrement, 
//nome text,
//ingredienteEscolha_id integer,
//FOREIGN KEY (ingredienteEscolha_id) REFERENCES ingredienteEscolha(id) 
//);
// 
//-- ingrediente_escolha definition 
//CREATE TABLE ingrediente_escolha ( 
//id integer not null primary key autoincrement,
//carrinho_id integer, 
//FOREIGN KEY (carrinho_id) REFERENCES carrinho(id)
//);
//
//-- carrinho definition 
//CREATE TABLE carrinho( 
//id integer not null primary key autoincrement, 
//qntd integer, 
//pedido_id integer,
//produto_id integer,
//ingredienteEscolha_id integer
//FOREIGN KEY (pedido_id) REFERENCES pedido(id), 
//FOREIGN KEY (produto_id) REFERENCES produto(id), 
//FOREIGN KEY (ingredienteEscolha_id) REFERENCES ingredienteEscolha(id), 
//); 
//
//-- bairro definition 
//CREATE TABLE bairro( 
//id integer not null primary key autoincrement, 
//nome text 
//); 
//
//-- endereco definition 
//CREATE TABLE endereco ( 
//id integer not null primary key autoincrement, 
//rua text,  
//cep text, 
//bairro_id, 
//distancia NUMERIC (2,2), 
//FOREIGN KEY (bairro_id) REFERENCES bairro(id) 
//); 
//
//-- delivery definition 
//CREATE TABLE delivery ( 
//id integer not null primary key autoincrement, 
//chaveEntrega text, 
//numero interger, 
//complemento text,
//endereco_id, 
//FOREIGN KEY (endereco_id) REFERENCES endereco(id) 
//);
// 
//-- login definition 
//CREATE TABLE login ( 
//id integer not null primary key autoincrement,
//password text,
//login_funcionario text
//); 
//
//-- funcionario definition 
//CREATE TABLE funcionario ( 
//id integer not null primary key autoincrement, 
//nome text, 
//cpf text, 
//rg text,
//login_id integer
//FOREIGN KEY (login_id) REFERENCES login(id) 
//); 
//-- cliente definition 
//CREATE TABLE cliente ( 
//id integer not null primary key autoincrement, nome text 
//); 
//-- telefone definition 
//CREATE TABLE telefone ( 
//id integer not null primary key autoincrement, 
//ddd text, 
//numero text,
//cliente_id,
//funcionario_id,
//FOREIGN KEY(cliente_id) REFERENCES cliente(id),
//FOREIGN KEY(funcionario_id) REFERENCES funcionario(id) 
//); 
// 
//-- entrega definition 
//CREATE TABLE entrega ( 
//id integer not null primary key autoincrement,
//cliente_id integer,
//tipoEntrega enum,
//delivery_id integer,
//pedido_id integer,
//status_pedido_id integer,
//FOREIGN KEY(cliente_id) REFERENCES cliente(id),
//FOREIGN KEY(delivery_id) REFERENCES delivery(id),
//FOREIGN KEY(pedido_id) REFERENCES pedido(id),
//FOREIGN KEY(status_pedido_id) REFERENCES statusPedido(id)
//);
//
//-- pedido definition 
//CREATE TABLE pedido ( 
//id integer not null primary key autoincrement,
//horaPedido date, 
//numeroPedido integer,
//dataPedido date, 
//cliente_id integer, 
//status_pedido_id integer,
//entrega_id integer,
//FOREIGN KEY(cliente_id) REFERENCES cliente(id),
//FOREIGN KEY(status_pedido_id) REFERENCES statusPedido(id),
//FOREIGN KEY(entrega_id) REFERENCES entrega(id),
//);
//
//-- status_pedido definition 
//CREATE TABLE statusPedido ( 
//id integer not null primary key autoincrement, 
//progresso text, 
//pedido_id integer,
//FOREIGN KEY(pedido_id) REFERENCES pedido(id),
//);
//
//-- reembolso definition 
//CREATE TABLE reembolso ( 
//id integer not null primary key autoincrement, 
//motivo text, 
//pedido_id integer, 
//FOREIGN KEY (pedido_id) REFERENCES pedido(id) 
//); 
//
//-- cartao definition 
//CREATE TABLE cartao ( 
//id integer not null primary key autoincrement, 
//numeroCartao text, 
//cvv text, 
//tipoConta integer ---1 credito, 2 debito 
//); 
//
//-- dinheiro definition 
//CREATE TABLE dinheiro ( 
//id integer not null primary key autoincrement, 
//valorEntreagado NUMERIC (3,2) 
//); 
//
//-- met_pagamento definition 
//CREATE TABLE metodoPagamento( 
//id integer not null primary key autoincrement, 
//pix text, 
//dinheiro_id integer, 
//cartao_id integer, 
//FOREIGN KEY (dinheiro_id) REFERENCES dinheiro(id),
//FOREIGN KEY (cartao_id ) REFERENCES cartao(id) 
//); 
//
//-- cupom definition 
//CREATE TABLE cupom(  
//id integer not null primary key autoincrement, 
//valorCupom integer, 
//codigo text, 
//validade date,
//pagamento_id,
//FOREIGN KEY(pagamento_id) REFERENCES pagamento(id),
//); 
//
//CREATE TABLE pagamento(  
//id integer not null primary key autoincrement, 
//metodo_pagamento_id integer, 
//cupom_id integer, 
//pedido_id integer, 
//FOREIGN KEY (metodo_pagamento_id) REFERENCES metedoPagamento(id), 
//FOREIGN KEY (cupom_id) REFERENCES cupom (id), 
//FOREIGN KEY (pedido_id) REFERENCES pedido (id) 
//); 


    
}
