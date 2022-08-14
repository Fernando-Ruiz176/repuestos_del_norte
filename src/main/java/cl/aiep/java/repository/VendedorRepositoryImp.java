package cl.aiep.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.model.Usuario;

@Repository
public class VendedorRepositoryImp implements UsuarioRepository{
	
	private static final String TABLA = "vendedores";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario makeObject(ResultSet rs, int row) throws SQLException {
		return new Usuario(rs.getInt("id"), rs.getString("rut"), rs.getString("nombre"), rs.getString("email"), null);
	}

	@Override
	public List<Usuario> findAll() {
		final String sql = String.format("SELECT * FROM %s", TABLA);
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Usuario findById(Long id) {
		final String sql = String.format("SELECT * FROM %s WHERE id = ?", TABLA);
		return (Usuario) jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Usuario vendedor) {
		String sql = "INSERT INTO %s (rut, nombre, email) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, vendedor.getRut(), vendedor.getNombre(), vendedor.getEmail() );
		
	}

	@Override
	public void edit(Usuario vendedor) {
		String sql = "UPDATE %s SET rut = ?, nombre = ?, email = ? WHERE id = ?";
		jdbcTemplate.update(sql, vendedor.getEmail(), vendedor.getNombre(), vendedor.getRut(), vendedor.getId() );
		
	}

	@Override
	public void delete(Long id) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, id);
		
	}
	
	
	
}
