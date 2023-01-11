package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Stat;

public interface StatsDAO {
	
	public List<Stat> getStats(int id);
}
