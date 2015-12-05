package ATM;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import DAO.ClienteDaoImplements;
import DAO.ProdutoDaoImplements;
import MODEL.Cliente;
import MODEL.Produto;

public class ComboBoxModelProdutos extends AbstractListModel implements ComboBoxModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String selecionado = "";
	
	private ProdutoDaoImplements proDAO = new ProdutoDaoImplements();
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	
	public ArrayList<Produto> lista() throws SQLException{
		if (produtos.isEmpty()) {
			produtos = proDAO.listar();
		}
		return produtos;
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
			Produto p = lista().get(index);
			result = p.getId() + " - " + p.getDescricao().trim() + " ("	+ p.getValorFormatado() + ")";
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
    public Float getSelectedItemValor(int index) throws SQLException {
        return lista().get(index).getValor();
    }
    
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
