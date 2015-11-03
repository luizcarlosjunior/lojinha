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

import ATM.ModeloCategoria;
import DAO.CategoriaDaoImplements;
import MODEL.Categoria;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MioloCategoria extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNOME;
	private JTable table;
	
	//conexão
	private CategoriaDaoImplements catDAO = new CategoriaDaoImplements();
	//modelo
	private ModeloCategoria modelo = new ModeloCategoria();
	

	/**
	 * Create the panel.
	 */
	public MioloCategoria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
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
		gbc_txtNOME.gridwidth = 2;
		gbc_txtNOME.insets = new Insets(0, 0, 5, 0);
		gbc_txtNOME.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNOME.gridx = 1;
		gbc_txtNOME.gridy = 2;
		add(txtNOME, gbc_txtNOME);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 13;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtNOME.setText( String.valueOf(modelo.getValueAt(table.getSelectedRow(),1) ).trim() );
				
			}
		});
		scrollPane.setViewportView(table);
		
		
		//seta o modelo na tabela
		table.setModel(modelo);
		
		JButton btnCriarNovo = new JButton("CRIAR NOVO REGISTRO");
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
		GridBagConstraints gbc_btnCriarNovo = new GridBagConstraints();
		gbc_btnCriarNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnCriarNovo.gridx = 1;
		gbc_btnCriarNovo.gridy = 17;
		add(btnCriarNovo, gbc_btnCriarNovo);
		
		JButton btnAtualizarRegistroSelecionado = new JButton("ATUALIZAR REGISTRO SELECIONADO");
		btnAtualizarRegistroSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Integer id = (Integer) modelo.getValueAt(table.getSelectedRow(),0);
					acao_atualizar(id, txtNOME.getText().trim());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnAtualizarRegistroSelecionado = new GridBagConstraints();
		gbc_btnAtualizarRegistroSelecionado.gridx = 2;
		gbc_btnAtualizarRegistroSelecionado.gridy = 17;
		add(btnAtualizarRegistroSelecionado, gbc_btnAtualizarRegistroSelecionado);
		
		//atualiza a lista
			try {
				acao_listar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	protected void acao_criar(String nome) throws SQLException {
		// criar modelo temoprario
		Categoria c = new Categoria(0, nome);
		//enviar para o DAO
		catDAO.inserir(c);
		//atualiza a lista
		acao_listar();
	}
	
	protected void acao_listar() throws SQLException {
		modelo.setList(catDAO.listar());
	}
	
	private void acao_atualizar(Integer id, String nome) throws SQLException {
		// criar modelo temoprario
		Categoria c = new Categoria(id, nome);
		//enviar para o DAO
		catDAO.atualizar(c);
		//atualiza a lista
		acao_listar();
	}

}
