package DAO;

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
		PreparedStatement ps = conn.prepareStatement("INSERT INTO USUARIOS (USUARIO_ID,SENHA) VALUES (?,?)");
		ps.setInt(1, u.getId_cliente());
		ps.setString(2, u.getSenha());
		ps.executeUpdate();
		ps.close();
		fecharConexao();
		
	}

	public void atualizar(Usuario u) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("UPDATE USUARIOS SET SENHA = ? WHERE USER_ID = ?");
		ps.setString(1, u.getSenha());
		ps.setInt(2, u.getId_cliente());
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
	public void excluir(int user_id) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM USUARIOS WHERE USER_ID = ?");
		ps.setInt(1, user_id);
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
		ResultSet result = st.executeQuery("SELECT * FROM USUARIOS WHERE USER_ID = " + user_id + " LIMIT = 1");
		
		Usuario u = new Usuario();
		
		while (result.next()) {
			u.setId( result.getInt(1) );
			u.setId_cliente( result.getInt(2) );
			u.setSenha( result.getString(3) );
		}
		
		fecharConexao();
		return u;
	}
	
	
	
}