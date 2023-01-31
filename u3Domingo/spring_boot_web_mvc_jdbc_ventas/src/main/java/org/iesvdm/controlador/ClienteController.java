package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.dao.ClienteDAOImpl;
import org.iesvdm.dto.ClienteDTO;
import org.iesvdm.mapstruct.ClienteMapper;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.service.ClienteService;
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
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	//@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Cliente> listaClientes =  clienteService.listAll();
		model.addAttribute("listaClientes", listaClientes);
				
		return "clientes";
		
	}
	
	@GetMapping("/clientes/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		Cliente cliente = clienteService.one(id);
		
		ClienteDTO clienteDTO = clienteMapper.detalleADetalleDTO(cliente, 0, 0, 0, 0, 0);
		
		Integer cliNumPedTri = clienteService.getNumPedTri(id);
		Integer cliNumPedSem = clienteService.getNumPedSem(id);
		Integer cliNumPedAnu = clienteService.getNumPedAnu(id);
		Integer cliNumPedLus = clienteService.getNumPedLus(id);
		
		
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("pedidosTri", cliNumPedTri);
		model.addAttribute("pedidosSem", cliNumPedSem);
		model.addAttribute("pedidosAnu", cliNumPedAnu);
		model.addAttribute("pedidosLus", cliNumPedLus);
		
		return "detalle-cliente";
		
	}
	
	@GetMapping("/clientes/crear") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String crear(@ModelAttribute("cliente") Cliente cliente, Model model) {
		
		return "crear-cliente";
		
	}
	
	@PostMapping({"/clientes/crear","/clientes/crear/"})
	public String submitCrear(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResulted, Model model, RuntimeException exception) {
		
		// Si no tiene errores
		if (bindingResulted.hasErrors()) {
			model.addAttribute("cliente", cliente);
			model.addAttribute("traza", exception.getMessage());
			return "crear-cliente";
		}
		System.out.println(bindingResulted);
		
		clienteService.newCliente(cliente);
		
		return "redirect:/clientes";
		
	}
	
	@GetMapping("/clientes/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		
		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);
		
		return "editar-cliente";
		
	}
	
	@PostMapping("/clientes/editar/{id}")
	public RedirectView submitEditar(@ModelAttribute("cliente") Cliente cliente) {
		
		clienteService.replaceCliente(cliente);		
		
		return new RedirectView("/clientes");
	}
	
	@PostMapping("/clientes/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		
		clienteService.deleteCliente(id);
		
		return new RedirectView("/clientes");
	}

}