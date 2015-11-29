package ATM;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import MODEL.Pedido;

public class ModeloPedido extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Pedido> lista = new ArrayList<Pedido>();
	
	public int getColumnCount() {
		return 5;
	}

	public int getRowCount() {
		return lista.size();
	}
	
	
	public void clear() {
		lista.clear();
	}
		
	public Object getValueAt(int row, int col) {
		
		Pedido p = lista.get(row);
		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getNome();
		case 2:
			return p.getTotal_itens();
		case 3:
			return p.getValor_liquido();	
		case 4:
			return p.getStatus();
		default:
			return "Erro";
		}
	}

	public void setList(ArrayList<Pedido> lista){
		this.lista = lista;
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {
		
		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Cliente";
		case 2:
			return "Itens";
		case 3:
			return "Valor";
		case 4:
			return "Status";
		default:
			return "Erro";
		}
	}
}
