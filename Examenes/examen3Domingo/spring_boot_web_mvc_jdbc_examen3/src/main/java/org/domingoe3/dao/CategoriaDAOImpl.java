package org.domingoe3.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.domingoe3.modelo.AlmacenCat;
import org.domingoe3.modelo.Categoria;
import org.domingoe3.modelo.Categoria;
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
public class CategoriaDAOImpl implements CategoriaDAO {

	 //Plantilla jdbc inyectada automáticamente por el framework Spring, gracias a la anotación @Autowired.
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	/**
	 * Devuelve Optional de Categoria con el ID dado.
	 */
	@Override
	public Optional<Categoria> find(int id) {
		
		Categoria cat =  jdbcTemplate
				.queryForObject("SELECT * FROM categoria WHERE id_categoria = ?"														
								, (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
            						 	rs.getString("nombre"),
            						 	rs.getDate("ultima_actualizacion")
            						 	)
								, id
								);
		
		if (cat != null) { 
			return Optional.of(cat);}
		else { 
			log.info("Categoria no encontrado.");
			return Optional.empty(); }
        
	}
	
	/**
	 * Devuelve lista con todos loa Categorias.
	 */
	@Override
	public List<Categoria> getAll() {
		
		List<Categoria> listFab = jdbcTemplate.query(
                "SELECT * FROM categoria",
                (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
                						 	rs.getString("nombre"),
                						 	rs.getDate("ultima_actualizacion")
                						 	)
        );
		
		log.info("Devueltos {} registros.", listFab.size());
		
        return listFab;
        
	}
	
	@Override
	public int getNumPelTot(int id) {
		
		int numTot = jdbcTemplate.queryForObject(
                "SELECT count(p.id_pelicula) FROM pelicula p JOIN pelicula_categoria pc ON p.id_pelicula = pc.id_pelicula WHERE pc.id_categoria = ?",Integer.class,id);
		
        return numTot;
        
	}
	
	@Override
	public List<AlmacenCat> getNumPelAlm(int id) {
		
		List<AlmacenCat> listFab = jdbcTemplate.query(
                "SELECT a.id_almacen as id, count(p.id_pelicula) as peliculas FROM pelicula p LEFT JOIN pelicula_categoria pc ON p.id_pelicula = pc.id_pelicula LEFT JOIN categoria c ON c.id_categoria = pc.id_categoria LEFT JOIN inventario i ON i.id_pelicula = pc.id_pelicula LEFT JOIN almacen a ON a.id_almacen = i.id_almacen WHERE c.id_categoria = ? GROUP BY a.id_almacen ORDER BY a.id_almacen",
                (rs, rowNum) -> new AlmacenCat(rs.getInt("id"),
                						 	rs.getInt("peliculas")
                						 	), id
        );
		
		log.info("Devueltos {} registros.", listFab.size());
		
        return listFab;
        
	}
	
}
