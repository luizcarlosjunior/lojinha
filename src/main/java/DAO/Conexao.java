package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	// Singleton
	private static Conexao conexao;
	
	public static Conexao getInstance() {
        return (conexao == null) ? (conexao = new Conexao()) : conexao;
    }

	
	private String link;
	private String user;
	private String pass;
	private String name;
	private String host;
	private String port;	

	static Connection conn;
	static Statement stm;
	
	Conexao() {
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

	public Connection abrirConexao() throws SQLException, ClassNotFoundException {
		try {
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(link + host + ":" + port + "/" + name, user, pass);
				System.out.println("conexão com o banco foi aberta!");
				
	        } catch (Exception e) {
	        	e.printStackTrace();
	            System.err.println(e.getClass().getName()+": "+e.getMessage());
	            System.exit(0);
	       }
		return conn;
	}

	public void fecharConexao() throws SQLException {
		conn.close();
		System.out.println("conexão com o banco foi fechada!");
	}

}
