package cl.aiep.java.repository;

import java.util.List;

import cl.aiep.java.model.Producto;



public interface ProductoRepository {
	
	public List<Producto> findAll();
	public Producto findById(Long id);
	public void create(Producto producto);
	public void edit (Producto producto);
	public void delete (Long id);

}
