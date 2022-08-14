package cl.aiep.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.model.Categoria;
import cl.aiep.java.model.Producto;


@Repository
public class ProductoRepositoryImp implements ProductoRepository{
	
	private static final String TABLA ="productos";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Producto makeObject(ResultSet rs, int row) throws SQLException {
		Long categoriaId  = rs.getLong("categoria_id");
		Categoria categoria = categoriaRepository.findById(categoriaId);
		return new Producto(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"), rs.getInt("stock"), rs.getInt("precio"), categoria);
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
