package DAO;

import java.util.List;

import MODEL.Categoria;

public interface CategoriaDao {
	
	public void inserir(Categoria c);

	public void atualizar(Categoria c);

	public void excluir(Categoria c);

	public Categoria buscar(int id);

	public List<Categoria> listar();
}
