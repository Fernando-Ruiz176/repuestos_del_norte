package cl.aiep.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.model.Cliente;
import cl.aiep.java.model.Pedido;
import cl.aiep.java.model.Producto;
import cl.aiep.java.model.Usuario;

@Repository
public class PedidoRepositoryImp implements PedidoRepository{
	
	private static final String TABLA = "pedidos";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	UsuarioRepository vendedorRepository;
	
	public Pedido makeObject(ResultSet rs, int row) throws SQLException{
		Long productoId			= 	rs.getLong("producto_id");
		Producto producto		=	productoRepository.findById(productoId);
		
		Long clienteId			=	rs.getLong("cliente_id");
		Cliente cliente			=	clienteRepository.findById(clienteId);
		
		Long vendedorId			=	rs.getLong("vendedor_id");
		Usuario vendedor		=	vendedorRepository.findById(vendedorId);
		
		return new Pedido(rs.getLong("id"), 
				rs.getObject("fecha", LocalDate.class),
				rs.getString("folio"),
				rs.getInt("detalle"),
				rs.getInt("total"),
				producto,
				cliente,
				vendedor
		);
	}

	@Override
	public List<Pedido> findAll() {
		final String sql = String.format("SELECT * FROM %s", TABLA);
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Pedido findById(Long id) {
		final String sql = String.format("SELECT * FROM %s WHERE id = ?", TABLA);
		return (Pedido) jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
