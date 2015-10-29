package br.univel.lojinha;

import java.util.List;

public interface UsuarioDao {
	
	public void inserir(Usuario u);

	public void atualizar(Usuario u);

	public void excluir(Usuario u);

	public Usuario buscar(int id);

	public List<Usuario> listar();
}
