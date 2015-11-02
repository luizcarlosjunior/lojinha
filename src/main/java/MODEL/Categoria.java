/*
 * Classe Categoria
 * serve para modelar a categoria
 * Luiz Carlos Szpikula Junior
 * 29/10/2015 20:18
 */

package MODEL;

public class Categoria {
	int id;
	String nome;

	public Categoria(){}
	
	public Categoria(int id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
