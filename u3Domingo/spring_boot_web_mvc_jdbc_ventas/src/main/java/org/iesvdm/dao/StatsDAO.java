package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Stat;

public interface StatsDAO {
	
	public List<Stat> getStats(int id);
	public List<Stat> getStatsMax(int id);
	public List<Stat> getStatsMin(int id);
	public List<Cliente> getStatsClientes(int id);
}
