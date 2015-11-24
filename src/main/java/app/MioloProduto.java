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

import ATM.ComboBoxModelCategorias;
import ATM.ComboBoxModelClientes;
import ATM.ModeloCliente;
import ATM.ModeloProduto;
import DAO.ClienteDaoImplements;
import DAO.ProdutoDaoImplements;
import MODEL.Cliente;
import MODEL.Produto;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;



public class MioloProduto extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigoDeBarras;
	private JTable table;
	
	//conexão
	private ProdutoDaoImplements prodDAO = new ProdutoDaoImplements();
	//modelo
	private ModeloProduto modelo = new ModeloProduto();
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTextField txtMargemLucro;
	private JComboBox cbUnidades = new JComboBox(ENUM.EnumUnidade.values());
	private JComboBox cbCategorias = new JComboBox();
	
	private ComboBoxModelCategorias comboBoxModelClientes = new ComboBoxModelCategorias();
	
	int status = 1;
	
	JButton btnAtualizarRegistroSelecionado = new JButton("SALVAR REGISTRO SELECIONADO");
	JButton btnCriarNovo = new JButton("SALVAR O NOVO PRODUTO");
	
	

	/**
	 * Create the panel.
	 */
	public MioloProduto() {
	    // esconde o botao de atualizar
	    btnAtualizarRegistroSelecionado.setVisible(false);
		
		//ja atualiza a janela de cara...
		atualiza_visao();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCdigoDeBarras = new JLabel("CÓDIGO DE BARRAS");
		lblCdigoDeBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 2;
		add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);
		
		txtCodigoDeBarras = new JTextField();
		txtCodigoDeBarras.setColumns(10);
		GridBagConstraints gbc_txtCodigoDeBarras = new GridBagConstraints();
		gbc_txtCodigoDeBarras.gridwidth = 2;
		gbc_txtCodigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigoDeBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigoDeBarras.gridx = 1;
		gbc_txtCodigoDeBarras.gridy = 2;
		add(txtCodigoDeBarras, gbc_txtCodigoDeBarras);
		
		JLabel lblPreco = new JLabel("PREÇO");
		GridBagConstraints gbc_lblPreco = new GridBagConstraints();
		gbc_lblPreco.anchor = GridBagConstraints.EAST;
		gbc_lblPreco.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreco.gridx = 3;
		gbc_lblPreco.gridy = 2;
		add(lblPreco, gbc_lblPreco);
		
		txtMargemLucro = new JTextField();
		GridBagConstraints gbc_txtMargemLucro = new GridBagConstraints();
		gbc_txtMargemLucro.insets = new Insets(0, 0, 5, 5);
		gbc_txtMargemLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMargemLucro.gridx = 4;
		gbc_txtMargemLucro.gridy = 2;
		add(txtMargemLucro, gbc_txtMargemLucro);
		txtMargemLucro.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("DESCRICAO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtDescricao = new JTextField();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.gridwidth = 2;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 3;
		add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblMargemLucro = new JLabel("LUCRO");
		GridBagConstraints gbc_lblMargemLucro = new GridBagConstraints();
		gbc_lblMargemLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMargemLucro.gridx = 3;
		gbc_lblMargemLucro.gridy = 3;
		add(lblMargemLucro, gbc_lblMargemLucro);
		
		txtPreco = new JTextField();
		GridBagConstraints gbc_txtPreco = new GridBagConstraints();
		gbc_txtPreco.insets = new Insets(0, 0, 5, 5);
		gbc_txtPreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPreco.gridx = 4;
		gbc_txtPreco.gridy = 3;
		add(txtPreco, gbc_txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblUnidade = new JLabel("Unidade");
		GridBagConstraints gbc_lblUnidade = new GridBagConstraints();
		gbc_lblUnidade.anchor = GridBagConstraints.EAST;
		gbc_lblUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidade.gridx = 0;
		gbc_lblUnidade.gridy = 4;
		add(lblUnidade, gbc_lblUnidade);
		
		
		GridBagConstraints gbc_cbUnidades = new GridBagConstraints();
		gbc_cbUnidades.gridwidth = 2;
		gbc_cbUnidades.insets = new Insets(0, 0, 5, 5);
		gbc_cbUnidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUnidades.gridx = 1;
		gbc_cbUnidades.gridy = 4;
		add(cbUnidades, gbc_cbUnidades);
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.gridx = 3;
		gbc_lblCategoria.gridy = 4;
		add(lblCategoria, gbc_lblCategoria);
		
		cbCategorias.setModel(comboBoxModelClientes);
		
		// para evitar dar erros
		cbCategorias.setSelectedIndex(1);
		
		
		GridBagConstraints gbc_cbCategorias = new GridBagConstraints();
		gbc_cbCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_cbCategorias.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategorias.gridx = 4;
		gbc_cbCategorias.gridy = 4;
		add(cbCategorias, gbc_cbCategorias);
		
		
		btnCriarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (status == 1){
					int id = 0;
					String codigo_de_barras = txtCodigoDeBarras.getText().trim();
					String categoria = cbCategorias.getSelectedItem().toString();
					String descricao = txtDescricao.getText().trim();
					String unidade = cbUnidades.getSelectedItem().toString();
					Float custo = Float.valueOf(txtPreco.getText().trim());
					Float margem_de_lucro = Float.valueOf(txtMargemLucro.getText().trim());
					
					Produto p = new Produto(id, codigo_de_barras, categoria, descricao, unidade, custo,margem_de_lucro);
	
					if(p.testa_validade()){
						try {
							acao_criar(p);
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
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 14;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
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
				Produto p;
				try {
					p = acao_buscar(id);
					
					txtCodigoDeBarras.setText( p.getCodigo_de_barras().trim() );
					txtDescricao.setText( p.getDescricao().trim() );
					txtMargemLucro.setText( Float.toString(p.getMargem_de_lucro()).trim() );
					cbCategorias.setEditable(true);
					cbCategorias.setSelectedItem( p.getCategoria().trim() );
					cbCategorias.setEditable(false);
					txtPreco.setText( Float.toString(p.getCusto()).trim() );
					cbUnidades.setEditable(true);
					cbUnidades.setSelectedItem( p.getUnidade().trim() );
					cbUnidades.setEditable(false);
					
					
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
		GridBagConstraints gbc_btnCriarNovo = new GridBagConstraints();
		gbc_btnCriarNovo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCriarNovo.gridx = 1;
		gbc_btnCriarNovo.gridy = 21;
		add(btnCriarNovo, gbc_btnCriarNovo);
		
		
		btnAtualizarRegistroSelecionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id = (Integer) modelo.getValueAt(table.getSelectedRow(),0);
					
					String codigo_de_barras = txtCodigoDeBarras.getText().trim();
					String categoria = cbCategorias.getSelectedItem().toString();
					String descricao = txtDescricao.getText().trim();
					String unidade = cbUnidades.getSelectedItem().toString();
					Float custo = Float.valueOf(txtPreco.getText().trim());
					Float margem_de_lucro = Float.valueOf(txtMargemLucro.getText().trim());
					
					Produto p = new Produto(id, codigo_de_barras, categoria, descricao, unidade, custo,margem_de_lucro);
					
					if(p.testa_validade()){
						try {
							acao_atualizar(p);
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
		gbc_btnAtualizarRegistroSelecionado.gridy = 21;
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
		gbc_btnApagarSelecionado.gridy = 21;
		add(btnApagarSelecionado, gbc_btnApagarSelecionado);
		
		//atualiza a lista
			try {
				acao_listar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	private void acao_criar(Produto p) throws SQLException {
		//enviar para o DAO
		prodDAO.inserir(p);
		//atualiza a lista
		acao_listar();
	}
	
	private void acao_listar() throws SQLException {
		modelo.setList(prodDAO.listar());
	}
	
	private Produto acao_buscar(int id) throws SQLException {
		//acao_listar();
		return prodDAO.buscar(id);
		
	}
	
	private void acao_apagar(int id) throws SQLException {
		//enviar para o DAO
		prodDAO.excluir(id);
		//atualiza a lista
		acao_listar();
	}
	
	private void acao_atualizar(Produto p) throws SQLException {
		//enviar para o DAO
		prodDAO.atualizar(p);
		//atualiza a lista
		acao_listar();
	}
	
	public void atualiza_visao(){
		if (status == 1){
			btnAtualizarRegistroSelecionado.setVisible(false);
			btnCriarNovo.setText("SALVAR O NOVO PRODUTO");
		}else{
			btnAtualizarRegistroSelecionado.setVisible(true);
			btnCriarNovo.setText("NOVO PRODUTO");
		}
	}
	

	public void limpar_campos(){
		txtCodigoDeBarras.setText("");
		txtDescricao.setText("");
		txtMargemLucro.setText("");
		txtPreco.setText("");
		cbCategorias.setEditable(true);
		cbCategorias.setSelectedIndex(0);
		cbCategorias.setEditable(false);
		cbUnidades.setEditable(true);
		cbUnidades.setSelectedIndex(0);
		cbUnidades.setEditable(false);
		btnAtualizarRegistroSelecionado.setVisible(false);
	}	

}
