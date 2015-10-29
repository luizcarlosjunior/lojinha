/*
 * Classe Item
 * serve para modelar o Item
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:19
 */

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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	public BigDecimal getValor_liquido() {
		return valor_liquido;
	}
	public void setValor_liquido(BigDecimal valor_liquido) {
		this.valor_liquido = valor_liquido;
	}
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public String getCodigo_de_barras() {
		return codigo_de_barras;
	}
	public void setCodigo_de_barras(String codigo_de_barras) {
		this.codigo_de_barras = codigo_de_barras;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public EnumUnidade getUnidade() {
		return unidade;
	}
	public void setUnidade(EnumUnidade unidade) {
		this.unidade = unidade;
	}
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public BigDecimal getMargem_de_lucro() {
		return margem_de_lucro;
	}
	public void setMargem_de_lucro(BigDecimal margem_de_lucro) {
		this.margem_de_lucro = margem_de_lucro;
	}
	public Categoria getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getCategoria_nome() {
		return categoria_nome;
	}
	public void setCategoria_nome(String categoria_nome) {
		this.categoria_nome = categoria_nome;
	}
	
}
