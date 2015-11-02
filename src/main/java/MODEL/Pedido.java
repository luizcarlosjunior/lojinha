/*
 * Classe Pedido
 * serve para modelar o Pedido
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:19
 */

package MODEL;

import java.math.BigDecimal;

public class Pedido {
	//dados do pedido
	int id;
	String data;
	BigDecimal valor_total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public BigDecimal getValor_total() {
		return valor_total;
	}
	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}
	public BigDecimal getValor_desconto() {
		return valor_desconto;
	}
	public void setValor_desconto(BigDecimal valor_desconto) {
		this.valor_desconto = valor_desconto;
	}
	public BigDecimal getValor_liquido() {
		return valor_liquido;
	}
	public void setValor_liquido(BigDecimal valor_liquido) {
		this.valor_liquido = valor_liquido;
	}
	public int getTotal_itens() {
		return total_itens;
	}
	public void setTotal_itens(int total_itens) {
		this.total_itens = total_itens;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
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
