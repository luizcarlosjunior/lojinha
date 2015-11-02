package DAO;

import java.util.List;

import MODEL.Produto;

public interface ProdutoDao extends templateDao{
	
	public void inserir(Produto p);

	public void atualizar(Produto p);

	public void excluir(Produto p);

	public Produto buscar(int id);

	public List<Produto> listar();
}
