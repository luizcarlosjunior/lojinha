package app;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import DAO.CategoriaDaoImplements;
import MODEL.Categoria;

public class MioloCategoria extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNOME;

	/**
	 * Create the panel.
	 */
	public MioloCategoria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnCriarNovo = new JButton("criar novo");
		btnCriarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					acao_criar(txtNOME.getText().trim());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JLabel label_1 = new JLabel("NOME");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		txtNOME = new JTextField();
		txtNOME.setColumns(10);
		GridBagConstraints gbc_txtNOME = new GridBagConstraints();
		gbc_txtNOME.insets = new Insets(0, 0, 5, 0);
		gbc_txtNOME.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNOME.gridx = 1;
		gbc_txtNOME.gridy = 2;
		add(txtNOME, gbc_txtNOME);
		GridBagConstraints gbc_btnCriarNovo = new GridBagConstraints();
		gbc_btnCriarNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnCriarNovo.gridx = 0;
		gbc_btnCriarNovo.gridy = 17;
		add(btnCriarNovo, gbc_btnCriarNovo);

	}
	
	
	
	
	protected void acao_criar(String nome) throws SQLException {
		// criar modelo temoprario
		Categoria c = new Categoria(0, nome);
		//enviar para o DAO
		CategoriaDaoImplements cDAO = new CategoriaDaoImplements();
		cDAO.inserir(c);
		
	}
	

}
