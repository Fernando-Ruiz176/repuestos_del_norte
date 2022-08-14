package cl.aiep.java.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.java.model.Cliente;


@Repository
public class ClienteRepositoryImp implements ClienteRepository{
	
	private static final String TABLA = "clientes";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Cliente makeObject(ResultSet rs, int row) throws SQLException{
		return new Cliente(rs.getInt("id"), rs.getString("rut"), rs.getString("razonSocial"), rs.getString("email"), rs.getString("telefono"), rs.getString("direccion"), rs.getString("region"));
	}

	@Override
	public List<Cliente> findAll() {
		final String sql = String.format("SELECT * FROM %s", TABLA);
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Cliente findById(Long id) {
		final String sql = String.format("SELECT * FROM %s WHERE id = ?", TABLA);
		return (Cliente) jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
