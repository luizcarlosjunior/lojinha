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
import javax.swing.JOptionPane;
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
	JComboBox cbGeneros = new JComboBox(ENUM.EnumGenero.values());
	JComboBox cbEstados = new JComboBox(ENUM.EnumEstado.values());
	
	int status = 1;
	
	JButton btnAtualizarRegistroSelecionado = new JButton("SALVAR REGISTRO SELECIONADO");
	JButton btnCriarNovo = new JButton("SALVAR O NOVO CLIENTE");
	
	

	/**
	 * Create the panel.
	 */
	public MioloCliente() {
		
		//ja atualiza a janela de cara...
		atualiza_visao();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		gbc_txtNome.gridwidth = 2;
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		add(txtNome, gbc_txtNome);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 2;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 4;
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
		gbc_txtTelefone.gridwidth = 2;
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
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtEndereco = new JTextField();
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.gridwidth = 2;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.gridx = 4;
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
		gbc_txtCidade.gridwidth = 2;
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
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		
		GridBagConstraints gbc_cbEstados = new GridBagConstraints();
		gbc_cbEstados.gridwidth = 2;
		gbc_cbEstados.insets = new Insets(0, 0, 5, 0);
		gbc_cbEstados.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstados.gridx = 4;
		gbc_cbEstados.gridy = 4;
		add(cbEstados, gbc_cbEstados);
		
		JLabel lblGenero = new JLabel("GÊNERO");
		GridBagConstraints gbc_lblGenero = new GridBagConstraints();
		gbc_lblGenero.anchor = GridBagConstraints.EAST;
		gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenero.gridx = 0;
		gbc_lblGenero.gridy = 5;
		add(lblGenero, gbc_lblGenero);
		
		
		GridBagConstraints gbc_cbGeneros = new GridBagConstraints();
		gbc_cbGeneros.gridwidth = 2;
		gbc_cbGeneros.insets = new Insets(0, 0, 5, 5);
		gbc_cbGeneros.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGeneros.gridx = 1;
		gbc_cbGeneros.gridy = 5;
		add(cbGeneros, gbc_cbGeneros);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 14;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				//troca o botao
				status = 0;
				atualiza_visao();
				
				// pega a row selecionada
				int id = (Integer) modelo.getValueAt(table.getSelectedRow(),0);
				
				// busca no banco pelos dados para ser mais seguro
				Cliente c;
				try {
					c = acao_buscar(id);
					
					txtNome.setText( c.getNome().trim() );
					txtTelefone.setText( c.getTelefone().trim() );
					txtEndereco.setText( c.getEndereco().trim() );
					txtCidade.setText( c.getCidade().trim() );
					cbEstados.setEditable(true);
					cbEstados.setSelectedItem( c.getEstado().trim() );
					cbEstados.setEditable(false);
					txtEmail.setText( c.getEmail().trim() );
					cbGeneros.setEditable(true);
					cbGeneros.setSelectedItem( c.getGenero().trim() );
					cbGeneros.setEditable(false);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Problemas ao resgatar os dados do cliente");
				}
		
				
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		
		//seta o modelo na tabela
		table.setModel(modelo);
		
		
		btnCriarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (status == 1){
					int id = 0;
					String nome = txtNome.getText().trim();
					String telefone = txtTelefone.getText().trim();
					String endereco = txtEndereco.getText().trim();
					String cidade = txtCidade.getText().trim();
					String estado = cbEstados.getSelectedItem().toString();
					String email = txtEmail.getText().trim();
					String genero = cbGeneros.getSelectedItem().toString();
					
					Cliente c = new Cliente(id, nome, telefone, endereco, cidade, estado, email, genero);
	
					if(c.testa_validade()){
						try {
							acao_criar(c);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	
					}else{
						JOptionPane.showMessageDialog(null, "Estão faltando dados do cliente");
					}
					
				} else {
					status = 1;
					limpar_campos();
					atualiza_visao();
				}
			}
		});
		GridBagConstraints gbc_btnCriarNovo = new GridBagConstraints();
		gbc_btnCriarNovo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCriarNovo.gridx = 1;
		gbc_btnCriarNovo.gridy = 20;
		add(btnCriarNovo, gbc_btnCriarNovo);
		
		
		btnAtualizarRegistroSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id = (Integer) modelo.getValueAt(table.getSelectedRow(),0);
					
					String nome = txtNome.getText().trim();
					String telefone = txtTelefone.getText().trim();
					String endereco = txtEndereco.getText().trim();
					String cidade = txtCidade.getText().trim();
					String estado = cbEstados.getSelectedItem().toString();
					String email = txtEmail.getText().trim();
					String genero = cbGeneros.getSelectedItem().toString();
					
					Cliente c = new Cliente(id, nome, telefone, endereco, cidade, estado, email, genero);
					
					if(c.testa_validade()){
						try {
							acao_atualizar(c);
							limpar_campos();
							
							//troca o botao
							status = 1;
							atualiza_visao();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					}else{
						JOptionPane.showMessageDialog(null, "Estão faltando dados do cliente");
					}					
		        } catch (Exception e_apaga) {
		        	JOptionPane.showMessageDialog(null, "Você precisa selecionar um elemento.");	
				}
				
			}
		});
		GridBagConstraints gbc_btnAtualizarRegistroSelecionado = new GridBagConstraints();
		gbc_btnAtualizarRegistroSelecionado.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizarRegistroSelecionado.gridx = 2;
		gbc_btnAtualizarRegistroSelecionado.gridy = 20;
		add(btnAtualizarRegistroSelecionado, gbc_btnAtualizarRegistroSelecionado);
		
		JButton btnApagarSelecionado = new JButton("APAGAR SELECIONADO");
		btnApagarSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					//busca o id
					int id = (Integer) modelo.getValueAt(table.getSelectedRow(),0);
					
					//pergunta se quer realmente apagar
					int confirmacao = JOptionPane.showConfirmDialog (null, "Quer realmente apagar o registro?","Confirmação", JOptionPane.YES_OPTION);
					
		            if(confirmacao == 0){
		            		
		            	// tenta apagar
						try {
							acao_apagar(id);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
		            }
				} catch (Exception e_apaga) {
					JOptionPane.showMessageDialog(null, "Você precisa selecionar um elemento.");	
				}
				
            
			
			
			}
			
		});
		GridBagConstraints gbc_btnApagarSelecionado = new GridBagConstraints();
		gbc_btnApagarSelecionado.insets = new Insets(0, 0, 5, 5);
		gbc_btnApagarSelecionado.gridx = 4;
		gbc_btnApagarSelecionado.gridy = 20;
		add(btnApagarSelecionado, gbc_btnApagarSelecionado);
		
		//atualiza a lista
			try {
				acao_listar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	private void acao_criar(Cliente c) throws SQLException {
		//enviar para o DAO
		cliDAO.inserir(c);
		//atualiza a lista
		acao_listar();
	}
	
	private void acao_listar() throws SQLException {
		modelo.setList(cliDAO.listar());
	}
	
	private Cliente acao_buscar(int id) throws SQLException {
		//acao_listar();
		return cliDAO.buscar(id);
		
	}
	
	private void acao_apagar(int id) throws SQLException {
		//enviar para o DAO
		cliDAO.excluir(id);
		//atualiza a lista
		acao_listar();
	}
	
	private void acao_atualizar(Cliente c) throws SQLException {
		//enviar para o DAO
		cliDAO.atualizar(c);
		//atualiza a lista
		acao_listar();
	}
	
	public void atualiza_visao(){
		if (status == 1){
			btnAtualizarRegistroSelecionado.setVisible(false);
			btnCriarNovo.setText("SALVAR O NOVO CLIENTE");
		}else{
			btnAtualizarRegistroSelecionado.setVisible(true);
			btnCriarNovo.setText("NOVO CLIENTE");
		}
	}
	

	public void limpar_campos(){
		txtNome.setText("");
		txtTelefone.setText("");
		txtEndereco.setText("");
		txtCidade.setText("");
		txtEmail.setText("");
		cbEstados.setEditable(true);
		cbEstados.setSelectedIndex(0);
		cbEstados.setEditable(false);
		cbGeneros.setEditable(true);
		cbGeneros.setSelectedIndex(0);
		cbGeneros.setEditable(false);
		btnAtualizarRegistroSelecionado.setVisible(false);
	}	

}
