package org.iesvegademijas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesvegademijas.model.Fabricante;
import org.iesvegademijas.model.Producto;

public class ProductoDAOImpl extends AbstractDAOImpl implements ProductoDAO{

	/**
	 * Inserta en base de datos el nuevo fabricante, actualizando el id en el bean fabricante.
	 */
	@Override	
	public synchronized void create(Producto producto) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        try {
        	conn = connectDB();


        	//1 alternativas comentadas:       
        	//ps = conn.prepareStatement("INSERT INTO fabricante (nombre) VALUES (?)", new String[] {"codigo"});        	
        	//Ver también, AbstractDAOImpl.executeInsert ...
        	//Columna fabricante.codigo es clave primaria auto_increment, por ese motivo se omite de la sentencia SQL INSERT siguiente. 
        	ps = conn.prepareStatement("INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            int idx = 1;
            ps.setString(idx++, producto.getNombre());
            ps.setDouble(idx++, producto.getPrecio());
            ps.setInt(idx++, producto.getCodigoFabricante());
                   
            int rows = ps.executeUpdate();
            if (rows == 0) 
            	System.out.println("INSERT de productos con 0 filas insertadas.");
            
            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next()) 
            	producto.setCodigo(rsGenKeys.getInt(1));
                      
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
	public List<Producto> getAll() {
		
		Connection conn = null;
		Statement s = null;
        ResultSet rs = null;
        
        List<Producto> listPro = new ArrayList<>(); 
        
        try {
        	conn = connectDB();

        	// Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
        	s = conn.createStatement();
            		
        	rs = s.executeQuery("SELECT p.codigo, p.nombre, p.precio, f.codigo, f.nombre "
        			+ "FROM producto p RIGHT JOIN fabricante f on p.codigo_fabricante = f.codigo "
        			+ "ORDER BY p.codigo ASC;");          
            while (rs.next()) {
            	Producto pro = new Producto();
            	int idx = 1;
            	pro.setCodigo(rs.getInt("p.codigo"));
            	pro.setNombre(rs.getString("p.nombre"));
            	pro.setPrecio(rs.getDouble("p.precio"));
            	pro.setCodigoFabricante(rs.getInt("f.codigo"));
            	pro.setNombre_fab(rs.getString("f.nombre"));
            	listPro.add(pro);
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
	 * Devuelve lista con todos loa fabricantes.
	 */
	@Override
	public List<Producto> getAllFilter() {
		
		Connection conn = null;
		Statement s = null;
        ResultSet rs = null;
        
        List<Producto> listPro = new ArrayList<>(); 
        
        try {
        	
        	conn = connectDB();

        	// Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
        	s = conn.createStatement();
            		
        	rs = s.executeQuery("SELECT p.codigo, p.nombre, p.precio, f.codigo, f.nombre "
        			+ "FROM producto p RIGHT JOIN fabricante f on p.codigo_fabricante = f.codigo "
        			+ "ORDER BY p.codigo ASC;");          
            while (rs.next()) {
            	Producto pro = new Producto();
            	int idx = 1;
            	pro.setCodigo(rs.getInt("p.codigo"));
            	pro.setNombre(rs.getString("p.nombre"));
            	pro.setPrecio(rs.getDouble("p.precio"));
            	pro.setCodigoFabricante(rs.getInt("f.codigo"));
            	pro.setNombre_fab(rs.getString("f.nombre"));
            	listPro.add(pro);
            	
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
	public Optional<Producto> find(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("SELECT * FROM producto WHERE codigo = ?");
        	
        	int idx =  1;
        	ps.setInt(idx, id);
        	
        	rs = ps.executeQuery();
        	
        	if (rs.next()) {
        		Producto pro = new Producto();
        		idx = 1;
        		pro.setCodigo(rs.getInt("codigo"));
        		pro.setNombre(rs.getString("nombre"));
        		pro.setPrecio(rs.getDouble("precio"));
        		pro.setCodigoFabricante(rs.getInt("codigo_fabricante"));
        		
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
	/**
	 * Actualiza producto con campos del bean producto según ID del mismo.
	 */
	@Override
	public void update(Producto producto) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("UPDATE producto SET nombre = ?, precio = ?, codigo_fabricante = ?  WHERE codigo = ?");
        	int idx = 1;
        	ps.setString(idx++, producto.getNombre());
            ps.setDouble(idx++, producto.getPrecio());
            ps.setInt(idx++, producto.getCodigoFabricante());
        	ps.setInt(idx, producto.getCodigo());
        	
        	int rows = ps.executeUpdate();
        	
        	if (rows == 0) 
        		System.out.println("Update de producto con 0 registros actualizados.");
        	
        } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
    
	}

	/**
	 * Borra producto con ID proporcionado.
	 */
	@Override
	public void delete(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = connectDB();
        	
        	ps = conn.prepareStatement("DELETE FROM producto WHERE codigo = ?");
        	int idx = 1;        	
        	ps.setInt(idx, id);
        	
        	int rows = ps.executeUpdate();
        	
        	if (rows == 0) 
        		System.out.println("Delete de producto con 0 registros eliminados.");
        	
        } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
            closeDb(conn, ps, rs);
        }
		
	}
	
	public static void main(String[] args) {
		ProductoDAO pd = new ProductoDAOImpl();
		
		// Obtener todos los productos
		List<Producto> lp = pd.getAll();
		
		lp.forEach(System.out::println);
		
		
		// Obtener el producto 1
		System.out.println("========");
		System.out.println(pd.find(2));
		
		// Insertar un nuevo producto
		System.out.println("========");
		Producto p1 = new Producto();
		
		p1.setNombre("Impresora Epson Ecotank");
		p1.setPrecio(100.0);
		p1.setCodigoFabricante(1);
		
		pd.create(p1);
		
		// Actualizar el ultimo producto
		p1.setCodigo(18);
		p1.setNombre("Impresora Epson Ecotank 8910");
		p1.setPrecio(89.95);
		p1.setCodigoFabricante(2);
		
		pd.update(p1);
		
		// Eliminar el producto insertado
		pd.delete(12);	
	}

}
