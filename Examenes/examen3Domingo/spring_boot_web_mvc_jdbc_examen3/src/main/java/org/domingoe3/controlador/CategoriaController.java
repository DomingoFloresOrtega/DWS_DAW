package org.domingoe3.controlador;

import java.util.List;

import org.domingoe3.dto.CategoriaDTO;
import org.domingoe3.mapstruct.CategoriaMapper;
import org.domingoe3.modelo.AlmacenCat;
import org.domingoe3.modelo.Categoria;
import org.domingoe3.service.CategoriaService;
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
//Los mappings de los métodos tendrían este valor /categorias como
//prefijo.
//@RequestMapping("/categorias")
public class CategoriaController {
	
	private CategoriaService categoriaService;
	
	@Autowired
	private CategoriaMapper categoriaMapper;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/categorias/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		Categoria categoria = categoriaService.one(id);	
		Integer catNumPelTot = categoriaService.getNumPelTot(id);
		List<AlmacenCat> catNumPelAlm = categoriaService.getNumPelAlm(id);
		
		CategoriaDTO categoriaDTO = categoriaMapper.detalleADetalleDTO(categoria, catNumPelTot, catNumPelAlm);
		
		model.addAttribute("categoriaDTO", categoriaDTO);
		model.addAttribute("categoria", categoria);
		
		return "detalle-categoria";
		
	}
}