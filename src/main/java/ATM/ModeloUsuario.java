package ATM;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import DAO.ClienteDaoImplements;
import MODEL.Usuario;

public class ModeloUsuario extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	private ClienteDaoImplements cliDAO = new ClienteDaoImplements();
	
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

		Usuario u = lista.get(row);
		
		
		switch (col) {
		case 0:
			return u.getId();
		case 1:
			try {
				return cliDAO.buscar(u.getId_cliente()).getNome();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			return "Erro";
		}
	}

	public void setList(ArrayList<Usuario> lista){
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
		default:
			return "Erro";
		}
	}
}
