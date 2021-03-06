/*
 * Classe Pedido
 * serve para modelar o Pedido
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:19
 */

package MODEL;

import java.sql.Timestamp;

public class Pedido {
	//dados do pedido
	int id;
	int status;
	Timestamp data;
	Float valor_total;
	Float valor_desconto;
	Float valor_liquido;
	int total_itens;
	// dados do cliente para persis
	int cliente_id;
	String nome;
	String telefone;
	String endereco;
	String cidade;
	String estado;
	String email;
	String genero;
	
	
	public Pedido(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getStatus(){
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp timestamp) {
		this.data = timestamp;
	}
	public Float getValor_total() {
		return valor_total;
	}
	public void setValor_total(Float valor_total) {
		this.valor_total = valor_total;
	}
	public Float getValor_desconto() {
		return valor_desconto;
	}
	public void setValor_desconto(Float valor_desconto) {
		this.valor_desconto = valor_desconto;
	}
	public Float getValor_liquido() {
		return valor_liquido;
	}
	public void setValor_liquido(Float valor_liquido) {
		this.valor_liquido = valor_liquido;
	}
	public int getTotal_itens() {
		return total_itens;
	}
	public void setTotal_itens(int total_itens) {
		this.total_itens = total_itens;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
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


}
