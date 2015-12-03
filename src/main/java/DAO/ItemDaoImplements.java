package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MODEL.Item;

public class ItemDaoImplements implements ItemDao {

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

	public void inserir(Item i) throws SQLException {
		
		//abrir a conexao
		abrirConexao();
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO ITENS (pedido_id, quantidade, produto_id,ccodigo_de_barras, descricao, unidade, custo, "
				+ "margem_de_lucro, valor, desconto,  valor_liquido, categoria_id, categoria_nome) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

		ps.setInt(1, i.getPedido_id());
		ps.setInt(2, i.getQuantidade());
		ps.setInt(3, i.getId_produto());
		ps.setString(4, i.getCodigo_de_barras());
		ps.setString(5, i.getDescricao().trim());
		ps.setString(6, i.getUnidade().toString());
		ps.setFloat(7, i.getCusto());
		ps.setFloat(8, i.getMargem_de_lucro());
		ps.setFloat(9, i.getValor());
		ps.setFloat(10, i.getDesconto());
		ps.setFloat(11, i.getValor_liquido());
		ps.setInt(12, i.getCategoria_id());
		ps.setString(13, i.getCategoria_nome().trim());
		
		ps.executeUpdate();
		
		ps.close();
		
		fecharConexao();
	}

	public void atualizar(Item i) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("UPDATE ITENS SET pedido_id = ?, quantidade = ?, produto_id = ?, codigo_de_barras = ?, descricao = ?, unidade = ?, custo = ?, margem_de_lucro = ?, valor = ?, desconto = ?, valor_liquido = ?, categoria_id = ?, categoria_nome = ? WHERE ID = ?");

		ps.setInt(1, i.getPedido_id());
		ps.setInt(2, i.getQuantidade());
		ps.setInt(3, i.getId_produto());
		ps.setString(4, i.getCodigo_de_barras());
		ps.setString(5, i.getDescricao().trim());
		ps.setString(6, i.getUnidade().toString());
		ps.setFloat(7, i.getCusto());
		ps.setFloat(8, i.getMargem_de_lucro());
		ps.setFloat(9, i.getValor());
		ps.setFloat(10, i.getDesconto());
		ps.setFloat(11, i.getValor_liquido());
		ps.setInt(12, i.getCategoria_id());
		ps.setString(13, i.getCategoria_nome().trim());
		ps.setInt(14, i.getId());
		
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	

	//listar todos os itens de um pedido...
	public ArrayList<Item> listar() throws SQLException {
			//abre a conexão
			abrirConexao();
			//prepara o statement
			Statement st = conn.createStatement();
			//busca todos os pedidos sem distinção
			ResultSet result = st.executeQuery("SELECT * FROM ITENS");
			//geta a lista de resultados
			ArrayList<Item> lista = montar_lista(result);
			//fecha a conexão
			fecharConexao();
			//retorna a lista de resultados
			return lista;
		}


	//listar todos os itens...
	public ArrayList<Item> listar_pedido(int pedido_id) throws SQLException {
			//abre a conexão
			abrirConexao();
			//prepara o statement
			Statement st = conn.createStatement();
			//busca todos os pedidos sem distinção
			ResultSet result = st.executeQuery("SELECT * FROM ITENS WHERE PEDIDO_ID = " + pedido_id);
			//geta a lista de resultados
			ArrayList<Item> lista = montar_lista(result);
			//fecha a conexão
			fecharConexao();
			//retorna a lista de resultados
			return lista;
		}
	
	

	public ArrayList<Item> montar_lista(ResultSet result) throws SQLException{

		ArrayList<Item> lista = new ArrayList<Item>();
		
		while (result.next()) {
			//gera o novo item
			Item i = new Item();
			//adiciona os dados coletados
			i.setId(result.getInt(1));
			i.setPedido_id(result.getInt(2));
			i.setQuantidade(result.getInt(3));
			i.setId_produto(result.getInt(4));
			i.setCodigo_de_barras(result.getString(5));
			i.setDescricao(result.getString(6));
			i.setUnidade( result.getString(7));
			i.setCusto(result.getFloat(8));
			i.setMargem_de_lucro(result.getFloat(9));
			i.setValor(result.getFloat(10));
			i.setDesconto(result.getFloat(11));
			i.setValor_liquido(result.getFloat(12));
			i.setCategoria_id(result.getInt(13));
			i.setCategoria_nome(result.getString(14));
		
			//adiciona na lista
			lista.add(i);
		}
		
		return lista;
	}
	
	
	
	public Item buscar(int id) throws SQLException {
		abrirConexao();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM ITENS WHERE ID = " + id + " LIMIT 1");
		
		//gera o novo item
		Item i = new Item();
		
		while (result.next()) {
			//adiciona os dados coletados
			i.setId(result.getInt(1));
			i.setPedido_id(result.getInt(2));
			i.setQuantidade(result.getInt(3));
			i.setId_produto(result.getInt(4));
			i.setCodigo_de_barras(result.getString(5));
			i.setDescricao(result.getString(6));
			i.setUnidade( result.getString(7));
			i.setCusto(result.getFloat(8));
			i.setMargem_de_lucro(result.getFloat(9));
			i.setValor(result.getFloat(10));
			i.setDesconto(result.getFloat(11));
			i.setValor_liquido(result.getFloat(12));
			i.setCategoria_id(result.getInt(13));
			i.setCategoria_nome(result.getString(14));
		}
		
		fecharConexao();
		return i;
	}
	
	public void excluir(int id) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM ITENS WHERE ID = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
}