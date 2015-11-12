package ATM;

import java.sql.SQLException;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import DAO.ClienteDaoImplements;

public class ComboBoxModelClientes extends AbstractListModel implements ComboBoxModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String selecionado = "";
	
	private ClienteDaoImplements cliDAO = new ClienteDaoImplements();
    
    // QUAL É A QUANTIDADE DE OPÇÕES NO COMBOBOX
    public int getSize(){
    	int result = 0;
        try {
			 result = cliDAO.listar().size();
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
			result = index + " - " + cliDAO.listar().get(index).getNome();
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

	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
