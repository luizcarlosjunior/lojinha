package app;

import javax.swing.JPanel;
import javax.swing.JRootPane;

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
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import ATM.ComboBoxModelClientes;
import ATM.ModeloCliente;
import ATM.ModeloPedido;
import ATM.ModeloUsuario;
import DAO.ClienteDaoImplements;
import DAO.PedidoDaoImplements;
import DAO.UsuarioDaoImplements;
import MODEL.Cliente;
import MODEL.Pedido;
import MODEL.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class MioloPedido extends JRootPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	
	//conexão
	private PedidoDaoImplements pedidoDAO = new PedidoDaoImplements();
	private ClienteDaoImplements clienteDAO = new ClienteDaoImplements();
	//modelo
	private ModeloPedido modelo = new ModeloPedido();
	
	JComboBox cbClientes = new JComboBox();
	JLabel lblClientes = new JLabel("CLIENTE:");
	JButton btnNovoPedido = new JButton("NOVO PEDIDO");
	JButton btnEditarPedido = new JButton("EDITAR PEDIDO SELECIONADO");
	
	private ComboBoxModelClientes comboBoxModelClientes = new ComboBoxModelClientes();
	
	

	private BlockPanel glass;
	
	
	/**
	 * Create the panel.
	 */
	public MioloPedido() {

	    
	    cbClientes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		try {
					acao_listar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    	}
	    });
		
		
	    cbClientes.setModel(comboBoxModelClientes);
	    
	    // para evitar dar erros
	    cbClientes.setSelectedIndex(1);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		GridBagConstraints gbc_lblClientes = new GridBagConstraints();
		gbc_lblClientes.anchor = GridBagConstraints.EAST;
		gbc_lblClientes.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientes.gridx = 0;
		gbc_lblClientes.gridy = 1;
		add(lblClientes, gbc_lblClientes);
		
		
		GridBagConstraints gbc_cbClientes = new GridBagConstraints();
		gbc_cbClientes.gridwidth = 3;
		gbc_cbClientes.insets = new Insets(0, 0, 5, 5);
		gbc_cbClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbClientes.gridx = 1;
		gbc_cbClientes.gridy = 1;
		add(cbClientes, gbc_cbClientes);
		
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
				//mostra o botão de editar pedido selecionado.
				btnEditarPedido.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);
		
		
		//seta o modelo na tabela
		table.setModel(modelo);
		
		
		btnNovoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					acao_criar();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		GridBagConstraints gbc_btnNovoPedido = new GridBagConstraints();
		gbc_btnNovoPedido.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovoPedido.gridx = 1;
		gbc_btnNovoPedido.gridy = 17;
		add(btnNovoPedido, gbc_btnNovoPedido);
		
		
		btnEditarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					acao_editar();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		});
		GridBagConstraints gbc_btnEditarPedido = new GridBagConstraints();
		gbc_btnEditarPedido.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditarPedido.gridx = 2;
		gbc_btnEditarPedido.gridy = 17;
		add(btnEditarPedido, gbc_btnEditarPedido);
		
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
	
	
	protected void acao_criar() throws SQLException, NoSuchAlgorithmException {
		
		//pega a data agora
		 java.util.Date date = new java.util.Date();
		
		// busca o id do cliente selecionado
		int cliente_id = comboBoxModelClientes.getSelectedItemID(cbClientes.getSelectedIndex());
		
		// busca o cliente para coletar seus dados
		Cliente c = clienteDAO.buscar(cliente_id);

		// criar modelo temoprario
		Pedido p = new Pedido();
		//seta os dados do pedido zerado...
		p.setStatus(1);
		p.setData(new Timestamp(date.getTime()));
		p.setValor_desconto((float) 0);
		p.setValor_liquido((float) 0);
		p.setValor_total((float) 0);
		p.setTotal_itens(0);
		//seta os dados do cliente
		p.setCliente_id(c.getId());
		p.setNome(c.getNome());
		p.setTelefone(c.getTelefone());
		p.setEndereco(c.getEndereco());
		p.setCidade(c.getCidade());
		p.setEstado(c.getEstado());
		p.setEmail(c.getEmail());
		p.setGenero(c.getGenero());
		
		
		//enviar para o DAO
		pedidoDAO.inserir(p);
		
		//atualiza a lista
		acao_listar();
	}
	
	protected void acao_listar() throws SQLException {
		int cliente_id = comboBoxModelClientes.getSelectedItemID(cbClientes.getSelectedIndex());
		modelo.setList(pedidoDAO.listar_pedidos_cliente(cliente_id));
		
		// esconde o botao de editar
		btnEditarPedido.setVisible(false);
	}
	
	
	protected void acao_apagar(int id) throws SQLException {
		pedidoDAO.excluir(id);
		//atualiza a lista
		acao_listar();
	}
	
	
	protected void acao_editar() throws SQLException {
		// pega o id do pedido
		int id = (Integer) modelo.getValueAt(table.getSelectedRow(),0);  
		// abre a janela de edição do pedido selecionado...
		JdPedidoEditar janela = new JdPedidoEditar(id);
        janela.setLocationRelativeTo(this);
        janela.setVisible(true);
        
        //atualiza o banco
        pedidoDAO.atualizar_valores(id);
        
		// pausa até que a janela seja fechada...
		acao_listar();
	}
		
	
}
