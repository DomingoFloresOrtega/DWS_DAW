package org.domingoe3.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.domingoe3.modelo.Idioma;
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
public class IdiomaDAOImpl implements IdiomaDAO {

	 //Plantilla jdbc inyectada automáticamente por el framework Spring, gracias a la anotación @Autowired.
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	/**
	 * Devuelve lista con todos loa Peliculas.
	 */
	@Override
	public List<Idioma> getAll() {
		
		List<Idioma> listFab = jdbcTemplate.query(
                "SELECT * FROM idioma",
                (rs, rowNum) -> new Idioma(rs.getInt("id_idioma"),
                						 	rs.getString("nombre"),
                						 	rs.getDate("ultima_actualizacion")
                						 	)
        );
		
		log.info("Devueltos {} registros.", listFab.size());
		
        return listFab;
        
	}
}
