package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String link;
	private String user;
	private String pass;
	private String name;
	private String host;
	private String port;	

	private static Connection conexao;

	private Conexao() {
		initialize();
	}

	private void initialize() {
		this.link = "jdbc:postgresql://";
		this.user = "postgres";
		this.pass = "postgres";
		this.name = "univel";
		this.host = "localhost";
		this.port = "5432";
	}

	public Connection abrirConexao() throws SQLException {

		conexao = DriverManager.getConnection(link + host + ":" + port + "/" + name, user, pass);
		
		return conexao;
	}

	public void fecharConexao() {

	}

}
