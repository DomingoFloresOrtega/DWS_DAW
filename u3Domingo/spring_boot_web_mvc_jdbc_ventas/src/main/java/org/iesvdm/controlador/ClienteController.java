package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.dao.ClienteDAOImpl;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
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
	
	@GetMapping("/clientes/crear") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String crear(Model model) {
		
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		return "crear-cliente";
		
	}
	
	@PostMapping("/clientes/crear")
	public RedirectView submitCrear(@ModelAttribute("cliente") Cliente cliente) {
		
		clienteService.newCliente(cliente);
				
		return new RedirectView("/clientes") ;
		
	}

}