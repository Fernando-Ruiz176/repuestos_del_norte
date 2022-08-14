package cl.aiep.java.repository;

import java.util.List;

import cl.aiep.java.model.Usuario;

public interface UsuarioRepository {
	
	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public void create(Usuario vendedor);
	public void edit(Usuario vendedor);
	public void delete(Long id);
	

}
