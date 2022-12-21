package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;
import org.iesvdm.service.ComercialService;
import org.iesvdm.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /comercial como
//prefijo.
//@RequestMapping("/comercial")
public class ComercialController {
	
	private ComercialService comercialService;
	private PedidoService pedidoService;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialController(ComercialService comercialService) {
		this.comercialService = comercialService;
	}
	
	//@RequestMapping(value = "/comercial", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/comercial") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Comercial> listaComerciales =  comercialService.listAll();
		
		model.addAttribute("listaComerciales", listaComerciales);
				
		return "comercial";
		
	}
	
	@GetMapping("/comercial/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		Comercial comercial = comercialService.one(id);
		List<Pedido> listaPedidos = pedidoService.listAll();
		
		model.addAttribute("comercial", comercial);
		model.addAttribute("listaPedidos", listaPedidos);
		
		return "detalle-comercial";
		
	}
	
	@GetMapping("/comercial/crear") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String crear(Model model) {
		
		Comercial comercial = new Comercial();
		model.addAttribute("comercial", comercial);
		
		return "crear-comercial";
		
	}
	
	@PostMapping({"/comercial/crear","/comercial/crear/"})
	public RedirectView submitCrear(@ModelAttribute("comercial") Comercial comercial) {
		
		comercialService.newComercial(comercial);
				
		return new RedirectView("/comercial") ;
		
	}
	
	@GetMapping("/comercial/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		
		Comercial comercial = comercialService.one(id);
		model.addAttribute("comercial", comercial);
		
		return "editar-comercial";
		
	}
	
	@PostMapping("/comercial/editar/{id}")
	public RedirectView submitEditar(@ModelAttribute("comercial") Comercial comercial) {
		
		comercialService.replaceComercial(comercial);		
		
		return new RedirectView("/comercial");
	}
	
	@PostMapping("/comercial/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		
		comercialService.deleteComercial(id);
		
		return new RedirectView("/comercial");
	}


}