package br.univel.lojinha;

import java.util.List;

public interface ProdutoDao {
	
	public void inserir(Produto p);

	public void atualizar(Produto p);

	public void excluir(Produto p);

	public Produto buscar(int id);

	public List<Produto> listar();
}
