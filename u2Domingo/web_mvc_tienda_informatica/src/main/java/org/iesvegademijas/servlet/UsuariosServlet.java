package org.iesvegademijas.servlet;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesvegademijas.dao.FabDTO;
import org.iesvegademijas.dao.FabricanteDAO;
import org.iesvegademijas.dao.FabricanteDAOImpl;
import org.iesvegademijas.model.Fabricante;

public class UsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * HTTP Method: GET
	 * Paths: 
	 * 		/usuarios/
	 * 		/usuarios/{id}
	 * 		/usuarios/edit/{id}
	 * 		/usuarios/create
	 */		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
		String orden = "1";
		String modo = "2";
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			FabricanteDAO fabDAO = new FabricanteDAOImpl();
			
			//GET 
			//	/usuarios/
			//	/usuarios
			
			orden = request.getParameter("ordenar-por");
			modo = request.getParameter("modo-ordenar");
			
			List<FabDTO> lista = null;
			
			if (orden == null) {
				lista = fabDAO.getAll().stream().map(f -> {
	    		FabDTO fDTO = new FabDTO();
	    			
	    		fDTO.setCodigo(f.getCodigo());
	    		fDTO.setNombre(f.getNombre());
	    		fDTO.setNumProductos(fabDAO.getCountProductos(f.getCodigo()).get());
	    			
	    		return fDTO;
	    			
	    		}).collect(toList());
			}
			
			
			request.setAttribute("listaUsuarios", lista);		
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
			        		       
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
			
			if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
				
				// GET
				// /usuarios/create									
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/crear-usuario.jsp");
        												
			
			} else if (pathParts.length == 2) {
				FabricanteDAO fabDAO = new FabricanteDAOImpl();
				// GET
				// /usuarios/{id}
				try {
					request.setAttribute("fabricante",fabDAO.find(Integer.parseInt(pathParts[1])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detalle-fabricante.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
				}
				
			} else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				FabricanteDAO fabDAO = new FabricanteDAOImpl();
				
				// GET
				// /usuarios/edit/{id}
				try {
					request.setAttribute("fabricante",fabDAO.find(Integer.parseInt(pathParts[2])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editar-usuario.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
				}
				
				
			} else {
				
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
			
			}
			
		}
		
		dispatcher.forward(request, response);
			 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String __method__ = request.getParameter("__method__");
		
		if (__method__ == null) {
			// Crear uno nuevo
			FabricanteDAO fabDAO = new FabricanteDAOImpl();
			
			String nombre = request.getParameter("nombre");
			Fabricante nuevoFab = new Fabricante();
			nuevoFab.setNombre(nombre);
			fabDAO.create(nuevoFab);			
			
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
		
		response.sendRedirect("/tienda_informatica/usuarios");
		//response.sendRedirect("/tienda_informatica/usuarios");
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FabricanteDAO fabDAO = new FabricanteDAOImpl();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		Fabricante fab = new Fabricante();
		
		try {
			
			int id = Integer.parseInt(codigo);
			fab.setCodigo(id);
			fab.setNombre(nombre);
			fabDAO.update(fab);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		FabricanteDAO fabDAO = new FabricanteDAOImpl();
		String codigo = request.getParameter("codigo");
		
		try {
			
			int id = Integer.parseInt(codigo);
		
		fabDAO.delete(id);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
}
