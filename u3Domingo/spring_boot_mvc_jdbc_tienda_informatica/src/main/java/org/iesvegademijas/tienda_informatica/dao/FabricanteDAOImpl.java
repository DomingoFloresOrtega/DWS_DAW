package org.iesvegademijas.tienda_informatica.dao;

import java.util.List;
import java.util.Optional;

import org.iesvegademijas.tienda_informatica.modelo.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class FabricanteDAOImpl  implements FabricanteDAO{

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	/**
	 * Inserta en base de datos el nuevo fabricante, actualizando el id en el bean fabricante.
	 */
	@Override	
	public synchronized void create(Fabricante fabricante) {
		
		jdbcTemplate.update("INSERT INTO fabricante (nombre) VALUES (?)",fabricante.getNombre());
		
	}

	/**
	 * Devuelve lista con todos loa fabricantes.
	 */
	@Override
	public List<Fabricante> getAll() {
		
		List<Fabricante> listFab = jdbcTemplate.query(
                "SELECT * FROM fabricante",
                (rs, rowNum) -> new Fabricante(rs.getInt("codigo"),rs.getString("nombre"))
        );
			
        return listFab;
        
	}

	/**
	 * Devuelve Optional de fabricante con el ID dado.
	 */
	@Override
	public Optional<Fabricante> find(int id) {
		
		Fabricante fab =  jdbcTemplate
				.queryForObject("SELECT * FROM fabricante WHERE codigo = ?"														
								, (rs, rowNum) -> new Fabricante(rs.getInt("codigo"),rs.getString("nombre"))  
								, id
								);
		
		if (fab != null) return Optional.of(fab);
		else return Optional.empty();
        
	}
	/**
	 * Actualiza fabricante con campos del bean fabricante según ID del mismo.
	 */
	@Override
	public void update(Fabricante fabricante) {
		
		int rows = jdbcTemplate.update("UPDATE fabricante SET nombre = ?  WHERE codigo = ?", fabricante.getNombre(), fabricante.getCodigo());
		if (rows == 0) System.out.println("Update de fabricante con 0 registros actualizados.");
    
	}

	/**
	 * Borra fabricante con ID proporcionado.
	 */
	@Override
	public void delete(int id) {
		
		int rows = jdbcTemplate.update("DELETE FROM fabricante WHERE codigo = ?", id);
		
		if (rows == 0) System.out.println("Update de fabricante con 0 registros actualizados.");		
		
	}

}
