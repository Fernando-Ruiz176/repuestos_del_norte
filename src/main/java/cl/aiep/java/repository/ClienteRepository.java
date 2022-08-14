package cl.aiep.java.repository;

import java.util.List;

import cl.aiep.java.model.Cliente;


public interface ClienteRepository {
	
	public List<Cliente> findAll();
	public Cliente findById(Long id);
	public void create(Cliente cliente);
	public void edit (Cliente cliente);
	public void delete (Long id);

}
