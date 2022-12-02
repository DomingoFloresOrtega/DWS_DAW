package examen.domingo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import examen.domingo.model.Empleado;

public class EmpleadoDAOImpl extends AbstractDAOImpl implements EmpleadoDAO{

	/**
	 * Inserta en base de datos el nuevo empleado, actualizando el id en el bean empleado.
	 */
	@Override	
	public synchronized void create(Empleado empleado) {
        
	}

	/**
	 * Devuelve lista con todos loa fabricantes.
	 */
	@Override
	public List<Empleado> getAll() {
		
		Connection conn = null;
		Statement s = null;
        ResultSet rs = null;
        
        List<Empleado> listPro = new ArrayList<>(); 
        
        try {
        	conn = connectDB();

        	// Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
        	s = conn.createStatement();
            		
        	rs = s.executeQuery("SELECT * FROM empleado");          
            while (rs.next()) {
            	Empleado emp = new Empleado();
            	int idx = 1;
            	emp.setCodigo(rs.getInt("id"));
            	emp.setNif(rs.getString("nif"));
            	emp.setNombre(rs.getString("nombre"));
            	emp.setApellido1(rs.getString("apellido1"));
            	emp.setApellido2(rs.getString("apellido2"));
            	listPro.add(emp);
            }
          
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, s, rs);
        }
        return listPro;
        
	}

	/**
	 * Devuelve Optional de fabricante con el ID dado.
	 */
	@Override
	public Optional<Empleado> find(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("SELECT * FROM empleado WHERE id = ?");
        	
        	int idx =  1;
        	ps.setInt(idx, id);
        	
        	rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		Empleado emp = new Empleado();
        		idx = 1;
        		emp.setCodigo(rs.getInt("id"));
        		emp.setNif(rs.getString("nif"));
        		emp.setNombre(rs.getString("nombre"));
        		emp.setApellido1(rs.getString("apellido1"));
        		emp.setApellido2(rs.getString("apellido2"));
        		emp.setCod_dept(rs.getInt("id_departamento"));
        		
        		return Optional.of(emp);
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
	
	
	
	/**
	 * Actualiza Empleado con campos del bean Empleado según ID del mismo.
	 */
	@Override
	public void update(Empleado empleado) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("UPDATE empleado SET nif = ?, nombre = ?, apellido1 = ?, apellido2 = ?, id_departamento = ?  WHERE id = ?");
        	int idx = 1;
        	ps.setString(idx++, empleado.getNif());
        	ps.setString(idx++, empleado.getNombre());
        	ps.setString(idx++, empleado.getApellido1());
        	ps.setString(idx++, empleado.getApellido2());
        	ps.setInt(idx++, empleado.getCod_dept());
        	ps.setInt(idx, empleado.getCodigo());
        	
        	int rows = ps.executeUpdate();
        	
        	if (rows == 0) 
        		System.out.println("Update de empleado con 0 registros actualizados.");
        	
        } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
    
	}

	/**
	 * Borra Empleado con ID proporcionado.
	 */
	@Override
	public void delete(int id) {
		
	}

}
