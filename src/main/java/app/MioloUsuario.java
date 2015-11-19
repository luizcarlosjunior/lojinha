package app;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import ATM.ComboBoxModelClientes;
import ATM.ModeloCliente;
import ATM.ModeloUsuario;
import DAO.UsuarioDaoImplements;
import MODEL.Cliente;
import MODEL.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;


public class MioloUsuario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSENHA;
	private JTable table;
	
	//conexão
	private UsuarioDaoImplements userDAO = new UsuarioDaoImplements();
	//modelo
	private ModeloUsuario modelo = new ModeloUsuario();
	
	JComboBox cbUsuarios = new JComboBox();
	JLabel lblUsurio = new JLabel("USUÁRIO:");
	JButton btnCriarNovo = new JButton("SALVAR O NOVO USUÁRIO");
	JButton btnAtualizarRegistroSelecionado = new JButton("ATUALIZAR SENHA DO SELECIONADO");
	
	private ComboBoxModelClientes comboBoxModelClientes = new ComboBoxModelClientes();
	
	/**
	 * Create the panel.
	 */
	public MioloUsuario() {
		
		
	    cbUsuarios.setModel(comboBoxModelClientes);
	    
	    // para evitar dar erros
	    cbUsuarios.setSelectedIndex(1);
	    // esconde o botao de atualizar
	    btnAtualizarRegistroSelecionado.setVisible(false);
	    
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.anchor = GridBagConstraints.EAST;
		gbc_lblUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsurio.gridx = 0;
		gbc_lblUsurio.gridy = 1;
		add(lblUsurio, gbc_lblUsurio);
		
		
		GridBagConstraints gbc_cbUsuarios = new GridBagConstraints();
		gbc_cbUsuarios.gridwidth = 3;
		gbc_cbUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_cbUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUsuarios.gridx = 1;
		gbc_cbUsuarios.gridy = 1;
		add(cbUsuarios, gbc_cbUsuarios);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 2;
		add(lblSenha, gbc_lblSenha);
		
		txtSENHA = new JTextField();
		txtSENHA.setColumns(10);
		GridBagConstraints gbc_txtSENHA = new GridBagConstraints();
		gbc_txtSENHA.gridwidth = 3;
		gbc_txtSENHA.insets = new Insets(0, 0, 5, 0);
		gbc_txtSENHA.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSENHA.gridx = 1;
		gbc_txtSENHA.gridy = 2;
		add(txtSENHA, gbc_txtSENHA);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 13;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnAtualizarRegistroSelecionado.setVisible(true);
				btnCriarNovo.setText("NOVO ACESSO");
				cbUsuarios.setVisible(false);
				lblUsurio.setVisible(false);
				
			}
		});
		scrollPane.setViewportView(table);
		
		
		//seta o modelo na tabela
		table.setModel(modelo);
		
		
		btnCriarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if (cbUsuarios.isVisible()) {
					// se esta visivel o seletor de clientes cria um novo...
					
					
					
					String senha = txtSENHA.getText().trim();
					
					int id_usuario = 0;

					try {
						id_usuario = comboBoxModelClientes.getSelectedItemID(cbUsuarios.getSelectedIndex());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
					if (senha.isEmpty() ){
						JOptionPane.showMessageDialog(null, "A senha não pode ficar em branco.");
					} else {
						try {
							acao_criar(id_usuario,senha);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "Desculpe mas este usuário já tem uma senha.");	
							e.printStackTrace();
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						txtSENHA.setText("");	
					}
					
				} else {
					// caso esteja oculto mostra os objetos
					btnCriarNovo.setText("SALVAR O NOVO USUÁRIO");
					btnAtualizarRegistroSelecionado.setVisible(false);
					cbUsuarios.setVisible(true);
					lblUsurio.setVisible(true);
					
				}
			}
		});
		GridBagConstraints gbc_btnCriarNovo = new GridBagConstraints();
		gbc_btnCriarNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnCriarNovo.gridx = 1;
		gbc_btnCriarNovo.gridy = 17;
		add(btnCriarNovo, gbc_btnCriarNovo);
		
		
		btnAtualizarRegistroSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int id = (Integer) modelo.getValueAt(table.getSelectedRow(),0);
					
					int id_usuario = 0; // TODO: fixar isso
					
					String senha = txtSENHA.getText().trim();
					
					if (senha.isEmpty()){
						JOptionPane.showMessageDialog(null, "A senha não pode ficar em branco.");	
					} else {
						int confirmacao = JOptionPane.showConfirmDialog (null, "Deseja realmente atualizar o registro?","Confirmação", JOptionPane.YES_OPTION);
						
			            if(confirmacao == 0){
			            	try {
								acao_atualizar(id, id_usuario, senha);
								txtSENHA.setText("");
								btnAtualizarRegistroSelecionado.setVisible(false);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			            }
					
					}

		        } catch (Exception e_atualiza) {
		        	JOptionPane.showMessageDialog(null, "Você precisa selecionar um elemento.");
		        }
			}
			
			
		});
		GridBagConstraints gbc_btnAtualizarRegistroSelecionado = new GridBagConstraints();
		gbc_btnAtualizarRegistroSelecionado.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtualizarRegistroSelecionado.gridx = 2;
		gbc_btnAtualizarRegistroSelecionado.gridy = 17;
		add(btnAtualizarRegistroSelecionado, gbc_btnAtualizarRegistroSelecionado);
		
		JButton btnNewButton = new JButton("APAGAR REGISTRO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
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
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 17;
		add(btnNewButton, gbc_btnNewButton);
		
		//atualiza a lista
			try {
				acao_listar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	protected void acao_criar(int id_usuario, String senha) throws SQLException, NoSuchAlgorithmException {
		
		// criar modelo temoprario
		Usuario u = new Usuario(0, id_usuario, senha_md5(senha));
		
		//enviar para o DAO
		userDAO.inserir(u);
		
		//atualiza a lista
		acao_listar();
	}
	
	protected void acao_listar() throws SQLException {
		modelo.setList(userDAO.listar());
	}
	
	private void acao_atualizar(int id, int id_usuario, String senha) throws SQLException, NoSuchAlgorithmException {
		// criar modelo temoprario
		Usuario u = new Usuario(id, id_usuario, senha_md5(senha));
		//enviar para o DAO
		userDAO.atualizar(u);
		//atualiza a lista
		acao_listar();
	}
	protected void acao_apagar(int id) throws SQLException {
		userDAO.excluir(id);
		//atualiza a lista
		acao_listar();
	}
	
	protected String senha_md5(String senha) throws NoSuchAlgorithmException {
		// md5 para a senha
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0,senha.length());
		return new BigInteger(1,m.digest()).toString(16);
	}

}
