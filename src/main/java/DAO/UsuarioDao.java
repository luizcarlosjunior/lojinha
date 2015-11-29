package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Usuario;

public interface UsuarioDao extends templateDao{
	
	public void inserir(Usuario u) throws SQLException;

	public void atualizar(Usuario u) throws SQLException;

	public void excluir(int user_id) throws SQLException;

	public Usuario buscar(int user_id) throws SQLException;

	public ArrayList<Usuario> listar() throws SQLException;
	
	public boolean login(int usuario_id, String senha) throws SQLException;

	
}
