package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ATM.ComboBoxModelClientes;
import ATM.ComboBoxModelProdutos;
import ATM.ModeloItem;
import DAO.ItemDaoImplements;
import DAO.PedidoDaoImplements;
import MODEL.Item;
import MODEL.Produto;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JdPedidoEditar extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	int id;

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	
	
	JComboBox cbProduto = new JComboBox();
	
	private ComboBoxModelProdutos comboBoxModelProdutos = new ComboBoxModelProdutos();
	JSpinner txtQuntidade = new JSpinner();
	
	//conexão
	private PedidoDaoImplements pedidoDAO = new PedidoDaoImplements();
	private ItemDaoImplements itemDAO = new ItemDaoImplements();
	
	//modelo
	private ModeloItem modelo = new ModeloItem();
	private JTextField txtTOTAL;
	JSpinner txtDesconto = new JSpinner();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdPedidoEditar dialog = new JdPedidoEditar(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdPedidoEditar(int id) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setAlwaysOnTop(true);
		
		this.id = id;
		cbProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					atualizar_valores();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		cbProduto.setModel(comboBoxModelProdutos);
		
		// para evitar dar erros
		cbProduto.setSelectedIndex(1);
		
		//ja atualiza a janela de cara...
		atualiza_visao();
		
		
		
		setBounds(100, 100, 674, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 83, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblProduto = new JLabel("PRODUTO:");
			GridBagConstraints gbc_lblProduto = new GridBagConstraints();
			gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
			gbc_lblProduto.anchor = GridBagConstraints.EAST;
			gbc_lblProduto.gridx = 0;
			gbc_lblProduto.gridy = 0;
			contentPanel.add(lblProduto, gbc_lblProduto);
		}
		{
			cbProduto.setSelectedIndex(1);
			GridBagConstraints gbc_cbProduto = new GridBagConstraints();
			gbc_cbProduto.gridwidth = 5;
			gbc_cbProduto.insets = new Insets(0, 0, 5, 5);
			gbc_cbProduto.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbProduto.gridx = 1;
			gbc_cbProduto.gridy = 0;
			contentPanel.add(cbProduto, gbc_cbProduto);
		}
		{
			JButton btnNewButton = new JButton("ADICIONAR AO PEDIDO");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton.anchor = GridBagConstraints.ABOVE_BASELINE;
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton.gridx = 6;
			gbc_btnNewButton.gridy = 0;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("QUANTIDADE:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			
			GridBagConstraints gbc_txtQuntidade = new GridBagConstraints();
			gbc_txtQuntidade.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtQuntidade.insets = new Insets(0, 0, 5, 5);
			gbc_txtQuntidade.gridx = 1;
			gbc_txtQuntidade.gridy = 1;
			txtQuntidade.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					try {
						atualizar_valores();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			txtQuntidade.setModel(new SpinnerNumberModel(1, 1, 999, 1));
			contentPanel.add(txtQuntidade, gbc_txtQuntidade);
		}
		{
			JLabel lblDesconto = new JLabel("DESCONTO (%):");
			GridBagConstraints gbc_lblDesconto = new GridBagConstraints();
			gbc_lblDesconto.anchor = GridBagConstraints.EAST;
			gbc_lblDesconto.insets = new Insets(0, 0, 5, 5);
			gbc_lblDesconto.gridx = 2;
			gbc_lblDesconto.gridy = 1;
			contentPanel.add(lblDesconto, gbc_lblDesconto);
		}
		{
			txtDesconto.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					try {
						atualizar_valores();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			txtDesconto.setModel(new SpinnerNumberModel(0, 0, 100, 1));
			GridBagConstraints gbc_txtDesconto = new GridBagConstraints();
			gbc_txtDesconto.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDesconto.insets = new Insets(0, 0, 5, 5);
			gbc_txtDesconto.gridx = 3;
			gbc_txtDesconto.gridy = 1;
			contentPanel.add(txtDesconto, gbc_txtDesconto);
		}
		{
			JLabel lblTotal = new JLabel("TOTAL:");
			GridBagConstraints gbc_lblTotal = new GridBagConstraints();
			gbc_lblTotal.anchor = GridBagConstraints.EAST;
			gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
			gbc_lblTotal.gridx = 4;
			gbc_lblTotal.gridy = 1;
			contentPanel.add(lblTotal, gbc_lblTotal);
		}
		{
			
			txtTOTAL = new JTextField();
			txtTOTAL.setEnabled(false);
			GridBagConstraints gbc_txtTOTAL = new GridBagConstraints();
			gbc_txtTOTAL.insets = new Insets(0, 0, 5, 5);
			gbc_txtTOTAL.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTOTAL.gridx = 5;
			gbc_txtTOTAL.gridy = 1;
			contentPanel.add(txtTOTAL, gbc_txtTOTAL);
			txtTOTAL.setColumns(10);
		}
		{
			JButton btnRemoverDoPedido = new JButton("REMOVER DO PEDIDO");
			GridBagConstraints gbc_btnRemoverDoPedido = new GridBagConstraints();
			gbc_btnRemoverDoPedido.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnRemoverDoPedido.insets = new Insets(0, 0, 5, 0);
			gbc_btnRemoverDoPedido.gridx = 6;
			gbc_btnRemoverDoPedido.gridy = 2;
			contentPanel.add(btnRemoverDoPedido, gbc_btnRemoverDoPedido);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 7;
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 3;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("FECHAR A JANELA");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	
	// ações
	
	
	private void acao_criar(Item i) throws SQLException {
		//enviar para o DAO
		itemDAO.inserir(i);
		//atualiza a lista
		acao_listar();
	}
	
	private void acao_listar() throws SQLException {
		modelo.setList(itemDAO.listar());
	}
	
	private void acao_apagar(int id) throws SQLException {
		//enviar para o DAO
		itemDAO.excluir(id);
		//atualiza a lista
		acao_listar();
	}
	
	private void acao_atualizar(Item i) throws SQLException {
		//enviar para o DAO
		itemDAO.atualizar(i);
		//atualiza a lista
		acao_listar();
	}
	
	public void atualiza_visao(){
		// implementar as regras
	}
	

	public void limpar_campos(){
		txtQuntidade.setValue(1);
		cbProduto.setSelectedIndex(0);
	}	
	
	public void atualizar_valores() throws SQLException{
		//coleta o valor do produto
		float valor = comboBoxModelProdutos.getSelectedItemValor(cbProduto.getSelectedIndex());
		//oleta a quantidade
		int qtd = (int) txtQuntidade.getValue();
		//coleta o valor do desconto em %
		int desconto = (int) txtDesconto.getValue();
		// faz a continha de padaria
		float total = (valor * qtd) - ((valor * qtd) * (desconto))/100;
		//coloca o resultado no valor total...
		txtTOTAL.setText("R$ " + String.valueOf(total));
	}	
	

}
