package DAO;

import java.util.List;

import MODEL.Item;

public interface ItemDao {
	
	public void inserir(Item i);

	public void atualizar(Item i);

	public void excluir(Item i);

	public Item buscar(int id);

	public List<Item> listar();
}
