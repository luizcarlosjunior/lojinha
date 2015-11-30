package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Pedido;

public interface PedidoDao extends templateDao{
	
	public void inserir(Pedido pedido) throws SQLException;

	public void atualizar(Pedido pedido) throws SQLException;

	public void excluir(int id) throws SQLException;

	public Pedido buscar(int id) throws SQLException;

	public ArrayList<Pedido> listar_pedidos_cliente(int cliente_id) throws SQLException;
	
	public ArrayList<Pedido> listar() throws SQLException;
	
	public void atualizar_valores(int id) throws SQLException;
	
}
