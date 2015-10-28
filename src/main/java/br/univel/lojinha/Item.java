package br.univel.lojinha;

import java.math.BigDecimal;

public class Item {
	int id;
	BigDecimal desconto;
	BigDecimal valor_liquido;
	
	//dados do produto
	int id_produto;
	String codigo_de_barras;
	String descricao;
	EnumUnidade unidade;
	BigDecimal custo;
	BigDecimal margem_de_lucro;
	//dados da categoria
	Categoria id_categoria;
	String categoria_nome;
}
