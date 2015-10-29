/*
 * Classe Produto
 * serve para modelar o produto
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:20
 */

package br.univel.lojinha;

import java.math.BigDecimal;

public class Produto {
	int id;
	String codigo_de_barras;
	Categoria categoria;
	String descricao;
	EnumUnidade unidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo_de_barras() {
		return codigo_de_barras;
	}
	public void setCodigo_de_barras(String codigo_de_barras) {
		this.codigo_de_barras = codigo_de_barras;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	BigDecimal custo;
	BigDecimal margem_de_lucro;
}
