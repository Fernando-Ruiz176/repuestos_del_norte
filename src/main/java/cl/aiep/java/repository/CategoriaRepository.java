package cl.aiep.java.repository;

import java.util.List;

import cl.aiep.java.model.Categoria;

public interface CategoriaRepository {
	
	public List<Categoria> findAll();
	public Categoria findById(Long id);
	public void create(Categoria categoria);
	public void edit (Categoria categoria);
	public void delete (Long id);

}
