package DAO;

import java.sql.SQLException;

public interface templateDao {
	
	public void abrirConexao() throws SQLException;
	
	public void fecharConexao() throws SQLException;
	
}
