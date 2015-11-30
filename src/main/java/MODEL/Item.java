/*
 * Classe Item
 * serve para modelar o Item
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:19
 */

package MODEL;

import ENUM.EnumUnidade;

public class Item {
	int id;
	Float desconto;
	Float valor_liquido;
	int pedido_id;
	int quantidade;
	
	//dados do produto
	int produto_id;
	String codigo_de_barras;
	String descricao;
	EnumUnidade unidade;
	Float custo;
	Float margem_de_lucro;
	Float valor;
	
	//dados da categoria
	Categoria categoria_id;
	String categoria_nome;
	
	
	public int getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	public int getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Float getDesconto() {
		return desconto;
	}
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	public Float getValor_liquido() {
		return valor_liquido;
	}
	public void setValor_liquido(Float valor_liquido) {
		this.valor_liquido = valor_liquido;
	}
	public int getId_produto() {
		return produto_id;
	}
	public void setId_produto(int produto_id) {
		this.produto_id = produto_id;
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
	public Float getCusto() {
		return custo;
	}
	public void setCusto(Float custo) {
		this.custo = custo;
	}
	public Float getMargem_de_lucro() {
		return margem_de_lucro;
	}
	public void setMargem_de_lucro(Float margem_de_lucro) {
		this.margem_de_lucro = margem_de_lucro;
	}
	public Categoria getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(Categoria categoria_id) {
		this.categoria_id = categoria_id;
	}
	public String getCategoria_nome() {
		return categoria_nome;
	}
	public void setCategoria_nome(String categoria_nome) {
		this.categoria_nome = categoria_nome;
	}
	
}
