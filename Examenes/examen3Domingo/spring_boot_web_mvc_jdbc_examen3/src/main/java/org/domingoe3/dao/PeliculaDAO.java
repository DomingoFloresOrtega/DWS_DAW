package org.domingoe3.dao;

import java.util.List;
import java.util.Optional;

import org.domingoe3.modelo.Pelicula;

public interface PeliculaDAO {

	public void create(Pelicula pelicula);
	
	public List<Pelicula> getAll();
	
	public Optional<Pelicula>  find(int id);
	
}
