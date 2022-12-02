package examen.domingo.servlet;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import examen.domingo.dao.EmpleadoDAO;
import examen.domingo.dao.EmpleadoDAOImpl;
import examen.domingo.model.Empleado;

@WebServlet(name = "EmpleadosServlet", urlPatterns = { "/empleados/*" })
public class EmpleadosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * HTTP Method: GET
	 * Paths: 
	 * 		/empleados/
	 * 		/empleados/{id}
	 * 		/empleados/edit/{id}
	 * 		/empleados/create
	 */		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			EmpleadoDAO eDAO = new EmpleadoDAOImpl();
			
			//GET 
			//	/empleados/
			//	/empleados
			
			List<Empleado> lista = eDAO.getAll();
			
			
			request.setAttribute("listaEmpleados", lista);		
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados.jsp");
			        		       
		} else {
			// GET
			// 		/usuarios/{id}
			// 		/usuarios/{id}/
			// 		/usuarios/edit/{id}
			// 		/usuarios/edit/{id}/
			// 		/usuarios/create
			// 		/usuarios/create/
			
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				EmpleadoDAO eDAO = new EmpleadoDAOImpl();
				
				// GET
				// /empleados/edit/{id}
				try {
					request.setAttribute("empleado",eDAO.find(Integer.parseInt(pathParts[2])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editar-empleado.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados.jsp");
				}
				
				
			} else {
				
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleados.jsp");
			
			}
			
		}
		
		dispatcher.forward(request, response);
			 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String pathInfo = request.getPathInfo(); //
		pathInfo = pathInfo.replaceAll("/$", "");
		String[] pathParts = pathInfo.split("/");
		
		String __method__ = request.getParameter("__method__");
		
		if (__method__ == null) {
			// Crear uno nuevo
			EmpleadoDAO uDAO = new EmpleadoDAOImpl();	
			
		} else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
			doPut(request, response);
			
		
		} else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización DELETE.
			doDelete(request, response);
			
			
			
		} else {
			
			System.out.println("Opción POST no soportada.");
			
		}
		
		response.sendRedirect("/web_empleados/empleados");
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EmpleadoDAO eDAO = new EmpleadoDAOImpl();
		Integer codigo = Integer.parseInt(request.getParameter("codigo"));
		String nif = request.getParameter("nif");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		Integer dep = Integer.parseInt(request.getParameter("id_depto"));
		Empleado u = new Empleado();
		
		try {
			
			u.setCodigo(codigo);
			u.setNif(nif);
			u.setNombre(nombre);
			u.setApellido1(apellido1);
			u.setApellido2(apellido2);
			u.setCod_dept(dep);
			eDAO.update(u);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
