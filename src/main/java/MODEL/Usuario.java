/*
 * Classe Usuário
 * serve para modelar o usuário
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:20
 */

package MODEL;


public class Usuario {
	int id;
	int id_cliente;
	String senha;
	
	public Usuario(){
	}
	
	public Usuario(int id, int id_cliente, String senha){
		this.id = id;
		this.id_cliente = id_cliente;
		this.senha = senha;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
