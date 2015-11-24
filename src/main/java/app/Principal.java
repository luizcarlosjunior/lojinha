package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//variaveis privadas
	static JPanel contentPane;
	static JTabbedPane tabbedPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnarquivo = new JMenu("Arquivo");
		menuBar.add(mnarquivo);
		
		JMenuItem mntmCategorias = new JMenuItem("Categorias");
		mntmCategorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chamar a lista de categorias
				TelaCategoriasLista();
				
			}
		});
		mnarquivo.add(mntmCategorias);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// chamar a lista de clientes
				TelaClientesLista();
			}
		});
		mnarquivo.add(mntmClientes);
		
		JMenuItem mntmprodutos = new JMenuItem("Produtos");
		mntmprodutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chamar a lista de produtos
				TelaProdutosLista();
			}
		});
		mnarquivo.add(mntmprodutos);
		
		JMenuItem mntmUsurios = new JMenuItem("Usuários");
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chamar a lista de usuarios
				TelaUsuariosLista();
				
			}
		});
		mnarquivo.add(mntmUsurios);
		
		JMenuItem mntmPedidos = new JMenuItem("Pedidos");
		mnarquivo.add(mntmPedidos);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); //fechar a aplicação
			}
		});
		mnarquivo.add(mntmSair);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
	}
	
	// chamada de tela de categorias
	private void TelaCategoriasLista() {
		final visaoCategoria Categoria = new visaoCategoria();
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(Categoria);
			}
		};
		Categoria.setCloseAction(action);

		tabbedPane.addTab("Categorias", Categoria);
	}
	
	//chamada de tela de clientes
	private void TelaClientesLista() {
		final visaoCliente Cliente = new visaoCliente();
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(Cliente);
			}
		};
		Cliente.setCloseAction(action);

		tabbedPane.addTab("Clientes", Cliente);
	}
	
	//chamada de tela de clientes
		private void TelaUsuariosLista() {
			final visaoUsuario Usuario = new visaoUsuario();
			ActionListener action = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tabbedPane.remove(Usuario);
				}
			};
			Usuario.setCloseAction(action);

			tabbedPane.addTab("Usuarios", Usuario);
		}
	


//chamada de tela de clientes
	private void TelaProdutosLista() {
		final visaoProduto Produto = new visaoProduto();
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(Produto);
			}
		};
		Produto.setCloseAction(action);

		tabbedPane.addTab("Produtos", Produto);
	}

		
		
	
}
