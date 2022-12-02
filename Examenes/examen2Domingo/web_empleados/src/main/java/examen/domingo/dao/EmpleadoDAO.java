package examen.domingo.dao;

import java.util.List;
import java.util.Optional;

import examen.domingo.model.Empleado;

public interface EmpleadoDAO {
	
	public void create(Empleado empleado);
	
	public List<Empleado> getAll();
	public Optional<Empleado>  find(int id);
	
	public void update(Empleado empleado);
	
	public void delete(int id);

}
