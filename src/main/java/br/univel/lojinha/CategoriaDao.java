package br.univel.lojinha;

import java.util.List;

public interface CategoriaDao {
	
	public void inserir(Categoria c);

	public void atualizar(Categoria c);

	public void excluir(Categoria c);

	public Categoria buscar(int id);

	public List<Categoria> listar();
}
