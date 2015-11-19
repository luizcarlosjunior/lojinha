package DAO;

import java.sql.SQLException;
import java.util.List;

import MODEL.Produto;

public interface ProdutoDao extends templateDao{
	
	public void inserir(Produto p) throws SQLException;

	public void atualizar(Produto p) throws SQLException;

	public void excluir(int id) throws SQLException;

	public Produto buscar(int id) throws SQLException;

	public List<Produto> listar() throws SQLException;
}
