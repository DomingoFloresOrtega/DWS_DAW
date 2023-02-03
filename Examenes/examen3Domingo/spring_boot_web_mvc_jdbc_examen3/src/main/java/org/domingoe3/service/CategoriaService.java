package org.domingoe3.service;

import java.util.List;
import java.util.Optional;

import org.domingoe3.dao.CategoriaDAO;
import org.domingoe3.modelo.Categoria;
import org.domingoe3.modelo.Pelicula;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	
	private CategoriaDAO categoriaDAO;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public CategoriaService(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
	
	public List<Categoria> listAll() {
		
		return categoriaDAO.getAll();
		
	}
	
	public Categoria one(Integer id) {
		Optional<Categoria> optCli = categoriaDAO.find(id);
		if (optCli.isPresent())
			return optCli.get();
		else 
			return null;
	}
	
	public int getNumPelTot(int id) {
		return categoriaDAO.getNumPelTot(id);
	}
	
	public int getNumPelAlm(int id) {
		return categoriaDAO.getNumPelAlm(id);
	}
}