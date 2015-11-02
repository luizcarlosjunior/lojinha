/*
 * Classe Usuário
 * serve para modelar o usuário
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:20
 */

package MODEL;


public class Usuario {
	int id;
	Cliente id_cliente;
	String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
