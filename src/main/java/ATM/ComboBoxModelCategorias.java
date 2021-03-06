package ATM;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import DAO.CategoriaDaoImplements;
import MODEL.Categoria;

public class ComboBoxModelCategorias extends AbstractListModel implements ComboBoxModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String selecionado = "";
	
	private CategoriaDaoImplements catDAO = new CategoriaDaoImplements();
	
	private ArrayList<Categoria> categoria = new ArrayList<Categoria>();
	
	
	public ArrayList<Categoria> lista() throws SQLException{
		if (categoria.isEmpty()) {
			categoria = catDAO.listar();
		}
		return categoria;
	}
	
    // QUAL É A QUANTIDADE DE OPÇÕES NO COMBOBOX
    public int getSize(){
    	int result = 0;
		try {
			result = lista().size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    }

    //QUAL O ELEMENTO A SER SELECIONADO
    public Object getElementAt(int index) { 
    	String result = "erro";
		try {
			result = lista().get(index).getId() + " - " + lista().get(index).getNome().trim();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }

    //PEGA O ELEMENTO SELECIONADO E JOGA NA VARIAVEL
    public void setSelectedItem(Object anItem) {
    	selecionado = (String) anItem;
    }
    
    public Object getSelectedItem() {
        return (String) selecionado;
    }
    
    public int getSelectedItemID(int index) throws SQLException {
        return lista().get(index).getId();
    }

    
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
