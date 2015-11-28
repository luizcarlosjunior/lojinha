package DAO;

import java.math.BigDecimal;
import java.util.List;

import MODEL.Item;

public interface ItemDao {
	
	public void inserir(Item item);

	public void atualizar(Item item);

	public void excluir(Item item);

	public Item buscar(int id);
	
	public int pedido_total_itens(int pedito_id);
	
	public BigDecimal pedido_valor_total(int pedido_id);
	
	public BigDecimal pedido_valor_desconto(int pedido_id);

	public List<Item> listar(int pedido_id);
}
