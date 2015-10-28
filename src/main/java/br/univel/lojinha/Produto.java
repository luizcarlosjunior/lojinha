package br.univel.lojinha;

import java.math.BigDecimal;

public class Produto {
	int id;
	String codigo_de_barras;
	Categoria categoria;
	String descricao;
	EnumUnidade unidade;
	BigDecimal custo;
	BigDecimal margem_de_lucro;
}
