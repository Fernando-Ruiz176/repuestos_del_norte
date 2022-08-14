package cl.aiep.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.model.Categoria;

@Repository
public class CategoriaRepositoryImp implements CategoriaRepository{
	
	private static final String TABLA = "categorias";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Categoria makeObject(ResultSet rs, int row) throws SQLException {
		return new Categoria(rs.getInt("id"), rs.getString("nombre"));
	}

	@Override
	public List<Categoria> findAll() {
		final String sql = String.format("SELECT * FROM %s", TABLA);
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Categoria findById(Long id) {
		final String sql = String.format("SELECT * FROM %s WHERE id = ?", TABLA);
		return (Categoria) jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	

}
