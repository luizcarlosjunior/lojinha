package DAO;

import java.util.List;

import MODEL.Cliente;

public interface ClienteDao extends templateDao{
	
	public void inserir(Cliente c);

	public void atualizar(Cliente c);

	public void excluir(Cliente c);

	public Cliente buscar(int id);

	public List<Cliente> listar();
}
