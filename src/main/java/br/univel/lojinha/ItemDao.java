package br.univel.lojinha;

import java.util.List;

public interface ItemDao {
	
	public void inserir(Item i);

	public void atualizar(Item i);

	public void excluir(Item i);

	public Item buscar(int id);

	public List<Item> listar();
}
