package org.domingoe3.controlador;

import java.util.List;

import org.domingoe3.modelo.Categoria;
import org.domingoe3.modelo.Idioma;
import org.domingoe3.modelo.Pelicula;
import org.domingoe3.service.CategoriaService;
import org.domingoe3.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /peliculas como
//prefijo.
//@RequestMapping("/peliculas")
public class PeliculaController {
	
	private PeliculaService peliculaService;
	private CategoriaService categoriaService;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public PeliculaController(PeliculaService peliculaService, CategoriaService categoriaService) {
		this.peliculaService = peliculaService;
		this.categoriaService = categoriaService;
	}
	
	//@RequestMapping(value = "/peliculas", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/peliculas") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Pelicula> listaPeliculas =  peliculaService.listAll();
		model.addAttribute("listaPeliculas", listaPeliculas);
				
		return "peliculas";
		
	}
	
	@GetMapping("/peliculas/crear") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String crear(@ModelAttribute("pelicula") Pelicula pelicula, Model model) {
		
		List<Idioma> listaIdiomas = peliculaService.listAllI();
		List<Categoria> listaCategorias = categoriaService.listAll();
	
		model.addAttribute("listaIdiomas", listaIdiomas);
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "crear-pelicula";
		
	}
	
	@PostMapping({"/peliculas/crear","/peliculas/crear/"})
	public String submitCrear(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult bindingResulted, Model model, RuntimeException exception) {
		
		// Si no tiene errores
		if (bindingResulted.hasErrors()) {
			model.addAttribute("pelicula", pelicula);
			model.addAttribute("traza", exception.getMessage());
			return "crear-pelicula";
		}
		System.out.println(bindingResulted);
		
		peliculaService.newPelicula(pelicula);
		
		return "redirect:/peliculas";
		
	}
}