package examen.domingo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import examen.domingo.model.Departamento;

public class DepartamentoDAOImpl extends AbstractDAOImpl implements DepartamentoDAO{

	/**
	 * Inserta en base de datos el nuevo departamento, actualizando el id en el bean departamento.
	 */
	@Override	
	public synchronized void create(Departamento departamento) {
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
        	conn = connectDB();


        	ps = conn.prepareStatement("INSERT INTO departamento (nombre, presupuesto, gastos) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            int idx = 1;
            ps.setString(idx++, departamento.getNombre());
            ps.setDouble(idx++, departamento.getPresupuesto());
            ps.setDouble(idx, departamento.getGastos());
                   
            int rows = ps.executeUpdate();
            if (rows == 0) 
            	System.out.println("INSERT de usuarios con 0 filas insertadas.");
            
            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) 
            	departamento.setCodigo(rsGenKeys.getInt(1));
                      
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
	}

	/**
	 * Devuelve lista con todos loa fabricantes.
	 */
	@Override
	public List<Departamento> getAll() {
		
		Connection conn = null;
		Statement s = null;
        ResultSet rs = null;
        
        List<Departamento> listDep = new ArrayList<>(); 
        
        try {
        	conn = connectDB();

        	// Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
        	s = conn.createStatement();
            		
        	rs = s.executeQuery("SELECT * FROM departamento;");          
            while (rs.next()) {
            	Departamento dep = new Departamento();
            	int idx = 1;
            	dep.setCodigo(rs.getInt("id"));
            	dep.setNombre(rs.getString("nombre"));
            	dep.setPresupuesto(rs.getDouble("presupuesto"));
            	listDep.add(dep);
            }
          
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, s, rs);
        }
        return listDep;
        
	}

	/**
	 * Devuelve Optional de fabricante con el ID dado.
	 */
	@Override
	public Optional<Departamento> find(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("SELECT * FROM departamento WHERE codigo = ?");
        	
        	int idx =  1;
        	ps.setInt(idx, id);
        	
        	rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		Departamento pro = new Departamento();
        		idx = 1;
        		pro.setCodigo(rs.getInt("codigo"));
        		
        		return Optional.of(pro);
        	}
        	
        } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
        
        return Optional.empty();
        
	}
	
	public List<DepDTO> getNumerosEmp() {
		
		Connection conn = null;
		Statement s = null;
        ResultSet rs = null;
        
        List<DepDTO> listDep = new ArrayList<>(); 
        
        try {
        	conn = connectDB();

        	// Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
        	s = conn.createStatement();
            		
        	rs = s.executeQuery("SELECT D.id,D.nombre,D.presupuesto,D.gastos, count(E.id) as numEmp "
        			+ "FROM departamento D left outer JOIN empleado E on D.id = E.id_departamento "
        			+ "GROUP BY D.id");        
            while (rs.next()) {
            	DepDTO dep = new DepDTO();
            	int idx = 1;
            	dep.setCodigo(rs.getInt("id"));
            	dep.setNombre(rs.getString("nombre"));
            	dep.setPresupuesto(rs.getDouble("presupuesto"));
            	dep.setGastos(rs.getDouble("gastos"));
            	dep.setNumEmpleados(rs.getInt("numEmp"));
            	listDep.add(dep);
            }
          
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, s, rs);
        }
        return listDep;
        
	}
	
	
	
	/**
	 * Actualiza Departamento con campos del bean Departamento según ID del mismo.
	 */
	@Override
	public void update(Departamento departamento) {
    
	}

	/**
	 * Borra Departamento con ID proporcionado.
	 */
	@Override
	public void delete(int id) {
		
	}

}
