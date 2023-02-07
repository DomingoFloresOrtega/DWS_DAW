package org.domingoe3.dao;

import java.util.List;
import java.util.Optional;

import org.domingoe3.modelo.AlmacenCat;
import org.domingoe3.modelo.Categoria;
import org.domingoe3.modelo.Pelicula;

public interface CategoriaDAO {
	
	public List<Categoria> getAll();
	
	public Optional<Categoria>  find(int id);
	
	public int getNumPelTot(int id);
	
	public List<AlmacenCat> getNumPelAlm(int id);
}
