package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Categoria;

public interface CategoriaDao extends templateDao{
	
	public void inserir(Categoria c) throws SQLException;

	public void atualizar(Categoria c) throws SQLException;

	public void excluir(int c) throws SQLException;

	public Categoria buscar(int id) throws SQLException;

	public ArrayList<Categoria> listar() throws SQLException;
	
}
