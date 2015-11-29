package app;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import DAO.UsuarioDaoImplements;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class PainelLogin extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JButton btnEntrar;
	private Runnable acaoOk;
	//conexão
	private UsuarioDaoImplements userDAO = new UsuarioDaoImplements();
	
	public PainelLogin() {
		
		
		
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.insets = new Insets(20, 20, 5, 5);
		gbc_lblUsurio.anchor = GridBagConstraints.EAST;
		gbc_lblUsurio.gridx = 0;
		gbc_lblUsurio.gridy = 0;
		add(lblUsurio, gbc_lblUsurio);

		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(20, 0, 5, 20);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 1;
		gbc_txtUsuario.gridy = 0;
		add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel = new JLabel("Senha");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 20, 20, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		txtSenha = new JPasswordField();
		GridBagConstraints gbc_txtSenha = new GridBagConstraints();
		gbc_txtSenha.insets = new Insets(0, 0, 20, 20);
		gbc_txtSenha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSenha.gridx = 1;
		gbc_txtSenha.gridy = 1;
		add(txtSenha, gbc_txtSenha);

		btnEntrar = new JButton("Entrar");
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 20, 0);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 2;
		add(btnEntrar, gbc_btnEntrar);
		
		
		// final
		configuraListeners();
	}

	private void configuraListeners() {

		txtUsuario.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtUsuario.transferFocus();
					
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres="0987654321";

				if(!caracteres.contains(e.getKeyChar()+"")){

				// se o caractere digitado for um contido na String caracteres

					e.consume(); // o caractere é removido através do método consume

				}
				
			}
		});
		
		txtSenha.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						logar();
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
	
		});
		
		
	}

	public PainelLogin(Runnable acaoOk) {
		this();
		
		this.acaoOk = acaoOk;
		
		btnEntrar.addActionListener(e -> {
			try {
				logar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}

	private void logar() throws HeadlessException, SQLException {
		
		// se nao foi digitado um usuario
		if (txtUsuario.getText().equals("") || txtSenha.getText().equals("")){
			JOptionPane.showMessageDialog(PainelLogin.this, "É preciso informar usuário e senha.");
		} else {
			int usuario_id = Integer.parseInt(txtUsuario.getText());
			String senha = txtSenha.getText();

			if ((usuario_mestre(usuario_id,senha) || userDAO.login(usuario_id,senha))) {
				acaoOk.run();
			} else {
				JOptionPane.showMessageDialog(PainelLogin.this, "Usuário e/ou senha inválidos!");
			}
		}
	}
	
	
	private boolean usuario_mestre(int usuario_id, String senha){
		
		boolean retorno = false;
		
		int usuario_mestre = 0;
		String senha_mestre = "senha";
		
		if ((usuario_id == usuario_mestre) && (senha.equals(senha_mestre))){
			retorno = true;
		}
		
		return retorno;
	}
	
	

}
