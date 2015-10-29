package br.univel.lojinha;

import java.util.List;

public interface PedidoDao {
	
	public void inserir(Pedido p);

	public void atualizar(Pedido p);

	public void excluir(Pedido p);

	public Pedido buscar(int id);

	public List<Pedido> listar();
}
