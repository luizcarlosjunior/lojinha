package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ENUM.EnumUnidade;
import MODEL.Categoria;
import MODEL.Produto;
import MODEL.Usuario;

public class ProdutoDaoImplements implements ProdutoDao {

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

	public void inserir(Produto p) throws SQLException {
		
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO PRODUTOS (codigo_de_barras,categoria,descricao,unidade,custo,margem_de_lucro) VALUES (?,?,?,?,?,?)");
		ps.setString(1, p.getCodigo_de_barras());
		ps.setString(2, p.getCategoria());
		ps.setString(3, p.getDescricao());
		ps.setString(4, p.getUnidade());
		ps.setFloat(5, p.getCusto());
		ps.setFloat(6, p.getMargem_de_lucro());
		
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}

	public void atualizar(Produto p) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("UPDATE PRODUTOS SET codigo_de_barras = ?, categoria = ?, descricao = ?, unidade = ?, custo = ?, margem_de_lucro = ? WHERE ID = ?");
		
		ps.setString(1, p.getCodigo_de_barras());
		ps.setString(2, p.getCategoria());
		ps.setString(3, p.getDescricao());
		ps.setString(4, p.getUnidade());
		ps.setFloat(5, p.getCusto());
		ps.setFloat(6, p.getMargem_de_lucro());
		
		ps.setInt(7, p.getId());
		
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
	public void excluir(int id) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM PRODUTOS WHERE ID = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	

	public ArrayList<Produto> listar() throws SQLException {
			ArrayList<Produto> lista = new ArrayList<Produto>();
			
			abrirConexao();
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM PRODUTOS");
			
			while (result.next()) {
				int id = result.getInt(1);
				String codigo_de_barras = result.getString(2);
				String categoria = result.getString(3);
				String descricao = result.getString(4);
				String unidade = result.getString(5);
				Float custo = result.getFloat(6);
				Float margem_de_lucro = result.getFloat(7);
				Produto p = new Produto(id,codigo_de_barras,categoria,descricao,unidade,custo,margem_de_lucro);
				lista.add(p);
			}
			
			fecharConexao();
			
			return lista;
		}


	public Produto buscar(int id) throws SQLException {
		abrirConexao();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM PRODUTOS WHERE ID = " + id + " LIMIT 1");
		
		Produto p = new Produto();
		
		while (result.next()) {
			p.setId(result.getInt(1));
			p.setCodigo_de_barras(result.getString(2));
			p.setCategoria(result.getString(3));
			p.setDescricao(result.getString(4));
			p.setUnidade(result.getString(5));
			p.setCusto(result.getFloat(6));
			p.setMargem_de_lucro(result.getFloat(7));
		}
		
		fecharConexao();
		return p;
	}

	
}