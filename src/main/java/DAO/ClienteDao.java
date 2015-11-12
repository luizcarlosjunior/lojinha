package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Cliente;

public interface ClienteDao extends templateDao{
	
	public void inserir(Cliente c) throws SQLException;

	public void atualizar(Cliente c) throws SQLException;

	public void excluir(int id) throws SQLException;

	public Cliente buscar(int id) throws SQLException;

	public ArrayList<Cliente> listar() throws SQLException;
}
