package cl.aiep.java.repository;

import java.util.List;

import cl.aiep.java.model.Pedido;

public interface PedidoRepository {
	
	public List<Pedido> findAll();
	public Pedido findById(Long id);
	public void create(Pedido pedido);
	public void edit (Pedido pedido);
	public void delete (Long id);

}
