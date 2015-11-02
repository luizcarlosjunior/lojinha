package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MODEL.Categoria;

public class CategoriaDaoImplements implements CategoriaDao {

	static Conexao conexao = new Conexao();
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
	
	
	public void inserir(Categoria c) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO CATEGORIAS (NOME) VALUES (?)");
		ps.setString(1, c.getNome());
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
	public void atualizar(Categoria c) throws SQLException {
		// TODO Auto-generated method stub
	}
	public void excluir(Categoria c) throws SQLException {
		// TODO Auto-generated method stub
		abrirConexao();
		PreparedStatement sql = ((Connection) conexao).prepareStatement("DELETE FROM CATEGORIAS WHERE ID = ?");
		sql.setInt(1, c.getId());
		sql.executeUpdate();
		sql.close();
		fecharConexao();
		
	}
	public Categoria buscar(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Categoria> listar() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		
		abrirConexao();
		Statement st = ((Connection) conexao).createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM CLIENTE");
		while (result.next()) {
			int id = result.getInt(1);
			String nome = result.getString(2);
			Categoria c = new Categoria(id, nome);
			lista.add(c);
		}
		fecharConexao();
		return lista;
	}
}