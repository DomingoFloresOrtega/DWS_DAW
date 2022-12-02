package examen.domingo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import examen.domingo.model.Departamento;

public interface DepartamentoDAO {
	
	public void create(Departamento departamento);
	
	public List<Departamento> getAll();
	public Optional<Departamento>  find(int id);
	
	public void update(Departamento departamento);
	
	public void delete(int id);
	
	public List<DepDTO> getNumerosEmp();
}
