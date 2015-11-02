package ATM;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import MODEL.Categoria;

public class ModeloCategoria extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Categoria> lista = new ArrayList<Categoria>();
	
	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return lista.size();
	}
	
	
	public void clear() {
		lista.clear();
	}
		
	public Object getValueAt(int row, int col) {

		Categoria c = lista.get(row);
		switch (col) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		default:
			return "Erro";
		}
	}

	public void setList(ArrayList<Categoria> list){
		lista = list;
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {
		
		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		default:
			return "Erro";
		}
	}
}
