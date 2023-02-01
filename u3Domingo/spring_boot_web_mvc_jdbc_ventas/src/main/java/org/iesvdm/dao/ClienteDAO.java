package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;

public interface ClienteDAO {

	public void create(Cliente cliente);
	
	public List<Cliente> getAll();
	public Optional<Cliente>  find(int id);
	
	public void update(Cliente cliente);
	
	public void delete(int id);
	
	public int getNumTot(int id);
	
	public int getNumPedTot(int id);
	
	public int getNumPedTri(int id);
	
	public int getNumPedSem(int id);
	
	public int getNumPedAnu(int id);
	
	public int getNumPedLus(int id);
	
}
