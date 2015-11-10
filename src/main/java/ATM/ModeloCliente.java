package ATM;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import MODEL.Cliente;

public class ModeloCliente extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cliente> lista = new ArrayList<Cliente>();
	
	public int getColumnCount() {
		return 8;
	}

	public int getRowCount() {
		return lista.size();
	}
	
	
	public void clear() {
		lista.clear();
	}
		
	public Object getValueAt(int row, int col) {

		Cliente c = lista.get(row);
		switch (col) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getTelefone();
		case 3:
			return c.getEndereco();	
		case 4:
			return c.getCidade();
		case 5:
			return c.getEstado();
		case 6:
			return c.getEmail();
		case 7:
			return c.getGenero();
		default:
			return "Erro";
		}
	}

	public void setList(ArrayList<Cliente> lista){
		this.lista = lista;
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName (int col) {
		
		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Telefone";
		case 3:
			return "Endereço";
		case 4:
			return "Cidade";
		case 5:
			return "Estado";
		case 6:
			return "Email";
		case 7:
			return "Genero";
		default:
			return "Erro";
		}
	}
}
