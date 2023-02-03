package org.domingoe3.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.domingoe3.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

//Anotación lombok para logging (traza) de la aplicación
@Slf4j
//Un Repository es un componente y a su vez un estereotipo de Spring 
//que forma parte de la ‘capa de persistencia’.
@Repository
public class PeliculaDAOImpl implements PeliculaDAO {

	 //Plantilla jdbc inyectada automáticamente por el framework Spring, gracias a la anotación @Autowired.
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override	
	public synchronized void create(Pelicula pelicula) {
		
		String sqlInsert = """
							INSERT INTO pelicula (id_pelicula, titulo, descripcion, anyo_lanzamiento, id_idioma, id_idioma_original, duracion_alquiler, rental_rate, duracion, replacement_cost, clasificacion, caracteristicas_especiales, ultima_actualizacion) 
							VALUES  (     ?,         ?,         ?,       ?,         ?     ?,     ?,     ?,     ?,     ?,     ?,     ?,     ?)
						   """;
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		//Con recuperación de id generado
		int rows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
			int idx = 1;
			ps.setString(idx++, pelicula.getTitulo());
			ps.setString(idx++, pelicula.getDescripcion());
			ps.setInt(idx++, pelicula.getAnio_lanzamiento());
			ps.setInt(idx++, pelicula.getId_idioma());
			ps.setInt(idx, pelicula.getId_idioma_original());
			ps.setInt(idx, pelicula.getDuracion_alquiler());
			ps.setDouble(idx, pelicula.getRental_rate());
			ps.setInt(idx, pelicula.getDuracion());
			ps.setDouble(idx, pelicula.getReplacement_cost());
			ps.setString(idx, pelicula.getClasificacion());
			ps.setString(idx, pelicula.getCaracteristicas_especiales());
			ps.setDate(idx, pelicula.getUltima_actualizacion());
			return ps;
		},keyHolder);
		
		pelicula.setId(keyHolder.getKey().intValue());

		log.info("Insertados {} registros.", rows);
	}

	/**
	 * Devuelve lista con todos loa Peliculas.
	 */
	@Override
	public List<Pelicula> getAll() {
		
		List<Pelicula> listFab = jdbcTemplate.query(
                "SELECT * FROM pelicula",
                (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"),
                						 	rs.getString("titulo"),
                						 	rs.getString("descripcion"),
                						 	rs.getInt("anyo_lanzamiento"),
                						 	rs.getInt("id_idioma"),
                						 	rs.getInt("id_idioma_original"),
                						 	rs.getInt("duracion_alquiler"),
                						 	rs.getDouble("rental_rate"),
                						 	rs.getInt("duracion"),
                						 	rs.getInt("replacement_cost"),
                						 	rs.getString("clasificacion"),
                						 	rs.getString("caracteristicas_especiales"),
                						 	rs.getDate("ultima_actualizacion")
                						 	)
        );
		
		log.info("Devueltos {} registros.", listFab.size());
		
        return listFab;
        
	}

	/**
	 * Devuelve Optional de Pelicula con el ID dado.
	 */
	@Override
	public Optional<Pelicula> find(int id) {
		
		Pelicula fab =  jdbcTemplate
				.queryForObject("SELECT * FROM pelicula WHERE id = ?"														
								, (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"),
            						 	rs.getString("titulo"),
            						 	rs.getString("descripcion"),
            						 	rs.getInt("anyo_lanzamiento"),
            						 	rs.getInt("id_idioma"),
            						 	rs.getInt("id_idioma_original"),
            						 	rs.getInt("duracion_alquiler"),
            						 	rs.getDouble("rental_rate"),
            						 	rs.getInt("duracion"),
            						 	rs.getInt("replacement_cost"),
            						 	rs.getString("clasificacion"),
            						 	rs.getString("caracteristicas_especiales"),
            						 	rs.getDate("ultima_actualizacion")
            						 	)
								, id
								);
		
		if (fab != null) { 
			return Optional.of(fab);}
		else { 
			log.info("Pelicula no encontrado.");
			return Optional.empty(); }
        
	}
}
