package DAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import MODEL.Usuario;

public class UsuarioDaoImplements implements UsuarioDao {

	Conexao conexao = new Conexao();
	Connection conn = null;
	
	
	public void abrirConexao() throws SQLException {
		try {
			conn = conexao.abrirConexao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fecharConexao() throws SQLException {
		conexao.fecharConexao();
	}

	public void inserir(Usuario u) throws SQLException {
		
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO USUARIOS (CLIENTE_ID,SENHA) VALUES (?,?)");
		ps.setInt(1, u.getId_cliente());
		ps.setString(2, u.getSenha());
		ps.executeUpdate();
		ps.close();
		fecharConexao();
		
	}

	public void atualizar(Usuario u) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("UPDATE USUARIOS SET SENHA = ? WHERE CLIENTE_ID = ?");
		ps.setString(1, u.getSenha());
		ps.setInt(2, u.getId_cliente());
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
	public void excluir(int id) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM USUARIOS WHERE ID = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	

	public ArrayList<Usuario> listar() throws SQLException {
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			abrirConexao();
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM USUARIOS");
			
			while (result.next()) {
				int id = result.getInt(1);
				int id_cliente = result.getInt(2);
				String senha = result.getString(3);
				Usuario u = new Usuario(id, id_cliente, senha);
				lista.add(u);
			}
			
			fecharConexao();
			
			return lista;
		}


	public Usuario buscar(int user_id) throws SQLException {
		abrirConexao();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM USUARIOS WHERE CLIENTE_ID = " + user_id + " LIMIT 1");
		
		Usuario u = new Usuario();
		
		while (result.next()) {
			u.setId( result.getInt(1) );
			u.setId_cliente( result.getInt(2) );
			u.setSenha( result.getString(3) );
		}
		
		fecharConexao();
		return u;
	}

	@Override
	public boolean login(int usuario_id, String senha) throws SQLException {
		boolean retorno = false;
		String senha_md5 = "";
		
		try {
			senha_md5 = senha_md5(senha);
			System.out.println(senha_md5);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		abrirConexao();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("SELECT CLIENTE_ID FROM USUARIOS WHERE CLIENTE_ID = " + usuario_id + " AND SENHA = '" + senha_md5 + "' LIMIT 1");
		// se tiver um retorno...
		if (result.next()){
			retorno = true;
		}
		
		return retorno;
	}
	
	protected String senha_md5(String senha) throws NoSuchAlgorithmException {
		// md5 para a senha
		MessageDigest m=MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0,senha.length());
		return new BigInteger(1,m.digest()).toString(16);
	}
	
}