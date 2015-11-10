package DAO;

import java.sql.SQLException;
import java.util.List;

import MODEL.Categoria;

public interface CategoriaDao extends templateDao{
	
	public void inserir(Categoria c) throws SQLException;

	public void atualizar(Categoria c) throws SQLException;

	public void excluir(int c) throws SQLException;

	public Categoria buscar(int id) throws SQLException;

	public List<Categoria> listar() throws SQLException;
	
}
