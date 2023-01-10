package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.PedidosDAO;
import org.iesvdm.modelo.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	private PedidosDAO pedidosDAO;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public PedidoService(PedidosDAO pedidosDAO) {
		this.pedidosDAO = pedidosDAO;
	}
	
	public List<Pedido> listAll() {
		
		return pedidosDAO.getAll();
		
	}
}