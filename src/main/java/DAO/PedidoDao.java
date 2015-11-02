package DAO;

import java.util.List;

import MODEL.Pedido;

public interface PedidoDao extends templateDao{
	
	public void inserir(Pedido p);

	public void atualizar(Pedido p);

	public void excluir(Pedido p);

	public Pedido buscar(int id);

	public List<Pedido> listar();
}
