package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MODEL.Pedido;

public class PedidoDaoImplements implements PedidoDao {

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

	public void inserir(Pedido p) throws SQLException {
		
		//abrir a conexao
		abrirConexao();
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO PEDIDOS (status, data, valor_total, valor_desconto, valor_liquido, "
				+ "cliente_id, nome, telefone, endereco, cidade, estado, email, genero, total_itens) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, p.getStatus());
		ps.setTimestamp(2, p.getData());
		ps.setFloat(3, p.getValor_total());
		ps.setFloat(4, p.getValor_desconto());
		ps.setFloat(5, p.getValor_liquido());
		ps.setInt(6, p.getCliente_id());
		ps.setString(7, p.getNome().trim());
		ps.setString(8, p.getTelefone().trim());
		ps.setString(9, p.getEndereco().trim());
		ps.setString(10, p.getCidade().trim());
		ps.setString(11, p.getEstado().trim());
		ps.setString(12,p.getEmail().trim());
		ps.setString(13, p.getGenero().trim());
		ps.setInt(14, p.getTotal_itens());
		
		ps.executeUpdate();
		
		ps.close();
		
		fecharConexao();
	}

	public void atualizar(Pedido p) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("UPDATE PEDIDOS SET status = ?, data = ?, valor_total = ?, valor_desconto = ?, valor_liquido = ?, cliente_id = ?, nome = ?, telefone = ?, endereco = ?, cidade = ?, estado = ?, email = ?, genero = ?, total_itens = ? WHERE ID = ?");

		ps.setInt(1, p.getStatus());
		ps.setTimestamp(2, p.getData());
		ps.setFloat(3, p.getValor_total());
		ps.setFloat(4, p.getValor_desconto());
		ps.setFloat(5, p.getValor_liquido());
		ps.setInt(6, p.getCliente_id());
		ps.setString(7, p.getNome());
		ps.setString(8, p.getTelefone());
		ps.setString(9, p.getEndereco());
		ps.setString(10, p.getCidade());
		ps.setString(11, p.getEstado());
		ps.setString(12,p.getEmail());
		ps.setString(13, p.getGenero());
		ps.setInt(14, p.getTotal_itens());
		
		ps.setInt(15, p.getId());
		
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}
	
	//listar todos os pedidos...
	public ArrayList<Pedido> listar() throws SQLException {
			//abre a conexão
			abrirConexao();
			//prepara o statement
			Statement st = conn.createStatement();
			//busca todos os pedidos sem distinção
			ResultSet result = st.executeQuery("SELECT * FROM PEDIDOS");
			//geta a lista de resultados
			ArrayList<Pedido> lista = montar_lista(result);
			//fecha a conexão
			fecharConexao();
			//retorna a lista de resultados
			return lista;
		}


	public ArrayList<Pedido> montar_lista(ResultSet result) throws SQLException{

		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		
		while (result.next()) {
			//gera o novo item de pedido
			Pedido p = new Pedido();
			//adiciona os dados coletados
			p.setId(result.getInt(1));
			p.setStatus(result.getInt(2));
			p.setData(result.getTimestamp(3));
			p.setValor_total(result.getFloat(4));
			p.setValor_desconto(result.getFloat(5));
			p.setValor_liquido(result.getFloat(6));
			p.setCliente_id(result.getInt(7));
			p.setNome(result.getString(8));
			p.setTelefone(result.getString(9));
			p.setEndereco(result.getString(10));
			p.setCidade(result.getString(11));
			p.setEstado(result.getString(12));
			p.setEmail(result.getString(13));
			p.setGenero(result.getString(14));
			//adiciona na lista
			lista.add(p);
		}
		
		return lista;
		
		
	}
	
	
	
	public Pedido buscar(int id) throws SQLException {
		abrirConexao();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("SELECT * FROM PEDIDOS WHERE ID = " + id + " LIMIT 1");
		
		Pedido p = new Pedido();
		
		while (result.next()) {
			//adiciona os dados coletados
			p.setId(result.getInt(1));
			p.setStatus(result.getInt(2));
			p.setData(result.getTimestamp(3));
			p.setValor_total(result.getFloat(4));
			p.setValor_desconto(result.getFloat(5));
			p.setValor_liquido(result.getFloat(6));
			p.setCliente_id(result.getInt(7));
			p.setNome(result.getString(8));
			p.setTelefone(result.getString(9));
			p.setEndereco(result.getString(10));
			p.setCidade(result.getString(11));
			p.setEstado(result.getString(12));
			p.setEmail(result.getString(13));
			p.setGenero(result.getString(14));
		}
		
		fecharConexao();
		return p;
	}
	
	public void excluir(int id) throws SQLException {
		abrirConexao();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM PEDIDOS WHERE ID = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		fecharConexao();
	}

	public ArrayList<Pedido> listar_pedidos_cliente(int cliente_id) throws SQLException {
		//abre a conexão
		abrirConexao();
		//prepara o statement
		Statement st = conn.createStatement();
		//busca todos os pedidos sem distinção
		ResultSet result = st.executeQuery("SELECT * FROM PEDIDOS WHERE cliente_id = " + cliente_id);
		//geta a lista de resultados
		ArrayList<Pedido> lista = montar_lista(result);
		//fecha a conexão
		fecharConexao();
		//retorna a lista de resultados
		return lista;
	}

	
}