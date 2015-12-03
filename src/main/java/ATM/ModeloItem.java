package ATM;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import MODEL.Item;

public class ModeloItem extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Item> lista = new ArrayList<Item>();
	
	public int getColumnCount() {
		return 6;
	}

	public int getRowCount() {
		return lista.size();
	}
	
	
	public void clear() {
		lista.clear();
	}
		
	public Object getValueAt(int row, int col) {
		
		Item i = lista.get(row);
		switch (col) {
		case 0:
			return i.getId();
		case 1:
			return i.getDescricao();
		case 2:
			return i.getUnidade();
		case 3:
			return i.getQuantidade();
		case 4:
			return i.getValor();
		case 5:
			return i.getDesconto();
		case 6:
			return i.getValor_liquido();
		default:
			return "Erro";
		}
	}

	public void setList(ArrayList<Item> lista){
		this.lista = lista;
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {
		
		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Descrição";
		case 2:
			return "Unidade";
		case 3:
			return "Quantidade";
		case 4:
			return "Valor Unitário";
		case 5:
			return "Valor de Desconto";
		case 6:
			return "Valor Líquido";
		default:
			return "Erro";
		}
	}
}
