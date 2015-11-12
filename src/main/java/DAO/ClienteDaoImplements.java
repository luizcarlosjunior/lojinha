package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MODEL.Cliente;

public class ClienteDaoImplements implements ClienteDao {

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
	
	
	public void inserir(Cliente c) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO CLIENTES (NOME,TELEFONE,ENDERECO,CIDADE,ESTADO,EMAIL,GENERO) VALUES (?,?,?,?,?,?,?)");
		ps.setString(1, c.getNome());
		ps.setString(2, c.getTelefone());
		ps.setString(3, c.getEndereco());
		ps.setString(4, c.getCidade());
		ps.setString(5, c.getEstado());
		ps.setString(6, c.getEmail());
		ps.setString(7, c.getGenero());
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
	public void atualizar(Cliente c) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("UPDATE CLIENTES SET NOME = ?,TELEFONE = ?,ENDERECO = ?,CIDADE = ?,ESTADO = ?,EMAIL = ?,GENERO = ? WHERE ID = ?");
		ps.setString(1, c.getNome());
		ps.setString(2, c.getTelefone());
		ps.setString(3, c.getEndereco());
		ps.setString(4, c.getCidade());
		ps.setString(5, c.getEstado());
		ps.setString(6, c.getEmail());
		ps.setString(7, c.getGenero());
		ps.setInt(8, c.getId());
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
	public void excluir(int id) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM CLIENTES WHERE ID = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
	public Cliente buscar(int id) throws SQLException {
		abrirConexao();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM CLIENTES WHERE ID = " + id + " LIMIT 1");
		
		Cliente c = new Cliente();
		
		while (result.next()) {
			c.setId( result.getInt(1) );
			c.setNome( result.getString(2) );
			c.setTelefone( result.getString(3) );
			c.setEndereco( result.getString(4) );
			c.setCidade( result.getString(5) );
			c.setEstado( result.getString(6) );
			c.setEmail( result.getString(7) );
			c.setGenero( result.getString(8) );
		}
		
		fecharConexao();
		return c;
	}
	
	public ArrayList<Cliente> listar() throws SQLException {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		abrirConexao();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM CLIENTES ORDER BY NOME");
		
		while (result.next()) {
			int id = result.getInt(1);
			String nome = result.getString(2);
			String telefone = result.getString(3);
			String endereco = result.getString(4);
			String cidade = result.getString(5);
			String estado = result.getString(6);
			String email = result.getString(7);
			String genero = result.getString(8);
			Cliente c = new Cliente(id, nome, telefone, endereco, cidade, estado, email, genero);
			lista.add(c);
		}
		
		fecharConexao();
		
		return lista;
	}
}