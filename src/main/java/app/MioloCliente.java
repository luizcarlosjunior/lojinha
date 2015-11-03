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

import ATM.ModeloCliente;
import DAO.ClienteDaoImplements;
import MODEL.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;



public class MioloCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTable table;
	
	//conexão
	private ClienteDaoImplements cliDAO = new ClienteDaoImplements();
	//modelo
	private ModeloCliente modelo = new ModeloCliente();
	private JTextField txtTelefone;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	

	/**
	 * Create the panel.
	 */
	public MioloCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label_1 = new JLabel("NOME");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		add(txtNome, gbc_txtNome);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 2;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("TELEFONE");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtTelefone = new JTextField();
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.gridx = 1;
		gbc_txtTelefone.gridy = 3;
		add(txtTelefone, gbc_txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ENDEREÇO");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtEndereco = new JTextField();
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.gridx = 3;
		gbc_txtEndereco.gridy = 3;
		add(txtEndereco, gbc_txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CIDADE");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtCidade = new JTextField();
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 4;
		add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ESTADO");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		final JComboBox cbEstados = new JComboBox(ENUM.EnumEstado.values());
		GridBagConstraints gbc_cbEstados = new GridBagConstraints();
		gbc_cbEstados.insets = new Insets(0, 0, 5, 0);
		gbc_cbEstados.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstados.gridx = 3;
		gbc_cbEstados.gridy = 4;
		add(cbEstados, gbc_cbEstados);
		
		JLabel lblGenero = new JLabel("GÊNERO");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 5;
		add(lblGenero, gbc_lblGenero);
		
		final JComboBox cbGeneros = new JComboBox(ENUM.EnumGenero.values());
		GridBagConstraints gbc_cbGeneros = new GridBagConstraints();
		gbc_cbGeneros.insets = new Insets(0, 0, 5, 5);
		gbc_cbGeneros.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGeneros.gridx = 1;
		gbc_cbGeneros.gridy = 5;
		add(cbGeneros, gbc_cbGeneros);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 14;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtNome.setText( String.valueOf(modelo.getValueAt(table.getSelectedRow(),1) ).trim() );
				txtTelefone.setText( String.valueOf(modelo.getValueAt(table.getSelectedRow(),2) ).trim() );
				txtEndereco.setText( String.valueOf(modelo.getValueAt(table.getSelectedRow(),3) ).trim() );
				txtCidade.setText( String.valueOf(modelo.getValueAt(table.getSelectedRow(),4) ).trim() );
				cbEstados.setSelectedItem( String.valueOf(modelo.getValueAt(table.getSelectedRow(),5)).trim() );
				txtEmail.setText( String.valueOf(modelo.getValueAt(table.getSelectedRow(),6) ).trim() );
				cbGeneros.setSelectedItem( String.valueOf(modelo.getValueAt(table.getSelectedRow(),7)).trim() );
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		
		//seta o modelo na tabela
		table.setModel(modelo);
		
		JButton btnCriarNovo = new JButton("CRIAR NOVO REGISTRO");
		btnCriarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Integer id = 0;
					String nome = txtNome.getText().trim();
					String telefone = txtTelefone.getText().trim();
					String endereco = txtEndereco.getText().trim();
					String cidade = txtCidade.getText().trim();
					String estado = cbEstados.getSelectedItem().toString();
					String email = txtEmail.getText().trim();
					String genero = cbGeneros.getSelectedItem().toString();

					Cliente c = new Cliente(id, nome, telefone, endereco, cidade, estado, email, genero);
					
					acao_criar(c);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnCriarNovo = new GridBagConstraints();
		gbc_btnCriarNovo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCriarNovo.gridx = 1;
		gbc_btnCriarNovo.gridy = 20;
		add(btnCriarNovo, gbc_btnCriarNovo);
		
		JButton btnAtualizarRegistroSelecionado = new JButton("ATUALIZAR REGISTRO SELECIONADO");
		btnAtualizarRegistroSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					Integer id = (Integer) modelo.getValueAt(table.getSelectedRow(),0);
					String nome = txtNome.getText().trim();
					String telefone = txtTelefone.getText().trim();
					String endereco = txtEndereco.getText().trim();
					String cidade = txtCidade.getText().trim();
					String estado = cbEstados.getSelectedItem().toString();
					String email = txtEmail.getText().trim();
					String genero = cbGeneros.getSelectedItem().toString();
					
					Cliente c = new Cliente(id, nome, telefone, endereco, cidade, estado, email, genero);
					
					acao_atualizar(c);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnAtualizarRegistroSelecionado = new GridBagConstraints();
		gbc_btnAtualizarRegistroSelecionado.insets = new Insets(0, 0, 5, 0);
		gbc_btnAtualizarRegistroSelecionado.gridx = 3;
		gbc_btnAtualizarRegistroSelecionado.gridy = 20;
		add(btnAtualizarRegistroSelecionado, gbc_btnAtualizarRegistroSelecionado);
		
		//atualiza a lista
			try {
				acao_listar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	protected void acao_criar(Cliente c) throws SQLException {
		//enviar para o DAO
		cliDAO.inserir(c);
		//atualiza a lista
		acao_listar();
	}
	
	protected void acao_listar() throws SQLException {
		modelo.setList(cliDAO.listar());
	}
	
	private void acao_atualizar(Cliente c) throws SQLException {
		//enviar para o DAO
		cliDAO.atualizar(c);
		//atualiza a lista
		acao_listar();
	}

}
