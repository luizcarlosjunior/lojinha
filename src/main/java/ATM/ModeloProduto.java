package ATM;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import MODEL.Produto;

public class ModeloProduto extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Produto> lista = new ArrayList<Produto>();
	
	public int getColumnCount() {
		return 7;
	}

	public int getRowCount() {
		return lista.size();
	}
	
	
	public void clear() {
		lista.clear();
	}
		
	public Object getValueAt(int row, int col) {
		
		Produto p = lista.get(row);
		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getCodigo_de_barras();
		case 2:
			return p.getCategoria();
		case 3:
			return p.getDescricao();	
		case 4:
			return p.getUnidade();
		case 5:
			return p.getCusto();
		case 6:
			return p.getMargem_de_lucro();
		default:
			return "Erro";
		}
	}

	public void setList(ArrayList<Produto> lista){
		this.lista = lista;
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {
		
		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Codigo de Barras";
		case 2:
			return "Categoria";
		case 3:
			return "Descricao";
		case 4:
			return "Unidade";
		case 5:
			return "Custo";
		case 6:
			return "Margem de Lucro";
		default:
			return "Erro";
		}
	}
}
