package br.univel.lojinha;

import java.math.BigDecimal;

public class Pedido {
	//dados do pedido
	int id;
	String data;
	BigDecimal valor_total;
	BigDecimal valor_desconto;
	BigDecimal valor_liquido;
	int total_itens;
	// dados do cliente
	int id_cliente;
	String nome;
	String telefone;
	String endereco;
	String cidade;
	String estado;
	String email;
	String genero;

}
