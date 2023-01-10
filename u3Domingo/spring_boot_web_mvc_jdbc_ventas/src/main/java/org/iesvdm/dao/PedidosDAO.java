package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Pedido;

public interface PedidosDAO {
	
	public List<Pedido> getAll();
}
