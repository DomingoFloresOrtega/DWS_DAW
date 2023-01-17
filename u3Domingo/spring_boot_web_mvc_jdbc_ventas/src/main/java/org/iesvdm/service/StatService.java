package org.iesvdm.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.*;

import org.iesvdm.dao.PedidosDAO;
import org.iesvdm.dao.StatsDAO;
import org.iesvdm.modelo.Cliente;
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
	
	public List<Stat> listMaxPed(int id) {
		
		return statsDAO.getStatsMax(id);
		
	}
	
	public List<Stat> listMinPed(int id) {
		
		return statsDAO.getStatsMin(id);
		
	}
	
	public List<Cliente> listClientes(int id) {
		
		return statsDAO.getStatsClientes(id);
		
	}
}