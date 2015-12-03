package DAO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import MODEL.Item;

public interface ItemDao {
	
	public void inserir(Item item) throws SQLException;

	public void atualizar(Item item) throws SQLException;

	public void excluir(int id) throws SQLException;

	public Item buscar(int id) throws SQLException;
	
	public List<Item> listar() throws SQLException;
	
	public List<Item> listar_pedido(int pedido_id) throws SQLException;
}
