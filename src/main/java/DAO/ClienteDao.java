package DAO;

import java.sql.SQLException;
import java.util.List;

import MODEL.Cliente;

public interface ClienteDao extends templateDao{
	
	public void inserir(Cliente c) throws SQLException;

	public void atualizar(Cliente c) throws SQLException;

	public void excluir(Cliente c) throws SQLException;

	public Cliente buscar(int id) throws SQLException;

	public List<Cliente> listar() throws SQLException;
}
