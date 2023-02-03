package org.domingoe3.service;

import java.util.List;
import java.util.Optional;

import org.domingoe3.dao.IdiomaDAO;
import org.domingoe3.dao.PeliculaDAO;
import org.domingoe3.modelo.Idioma;
import org.domingoe3.modelo.Pelicula;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {
	
	private PeliculaDAO peliculaDAO;
	private IdiomaDAO idiomaDAO;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public PeliculaService(PeliculaDAO peliculaDAO, IdiomaDAO idiomaDAO) {
		this.peliculaDAO = peliculaDAO;
		this.idiomaDAO = idiomaDAO;
	}
	
	public List<Pelicula> listAll() {
		
		return peliculaDAO.getAll();
		
	}
	
	public List<Idioma> listAllI() {
		
		return idiomaDAO.getAll();
		
	}
	
	public Pelicula one(Integer id) {
		Optional<Pelicula> optCli = peliculaDAO.find(id);
		if (optCli.isPresent())
			return optCli.get();
		else 
			return null;
	}
	
	public void newPelicula(Pelicula categoria) {
		peliculaDAO.create(categoria);
	}
}