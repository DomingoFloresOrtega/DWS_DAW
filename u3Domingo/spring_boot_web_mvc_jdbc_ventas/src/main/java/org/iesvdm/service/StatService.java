package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.PedidosDAO;
import org.iesvdm.dao.StatsDAO;
import org.iesvdm.modelo.Pedido;
import org.iesvdm.modelo.Stat;
import org.springframework.stereotype.Service;

@Service
public class StatService {
	
	private StatsDAO statsDAO;
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public StatService(StatsDAO statsDAO) {
		this.statsDAO = statsDAO;
	}
	
	public List<Stat> listAll(int id) {
		
		return statsDAO.getStats(id);
		
	}
}