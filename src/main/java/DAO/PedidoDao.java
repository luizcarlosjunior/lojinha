package DAO;

import java.util.List;

import MODEL.Pedido;

public interface PedidoDao extends templateDao{
	
	public void inserir(Pedido pedido);

	public void atualizar(Pedido pedido);

	public void excluir(Pedido pedido);

	public Pedido buscar(int id);

	public List<Pedido> listar_pedidos_cliente(int cliente_id);
	
	public List<Pedido> listar();
}
