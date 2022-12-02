package examen.domingo.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examen.domingo.dao.DepDTO;
import examen.domingo.dao.DepartamentoDAO;
import examen.domingo.dao.DepartamentoDAOImpl;
import examen.domingo.model.Departamento;

import static java.util.stream.Collectors.*;

/**
 * Servlet implementation class Departamentos
 */
@WebServlet(name = "DepartamentosServlet", urlPatterns = { "/departamentos/*" })
public class DepartamentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartamentosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * HTTP Method: GET
	 * Paths: 
	 * 		/departamentos/(index)
	 * 		/departamentos/{id}
	 * 		/departamentos/edit/{id}
	 * 		/departamentos/crear
	 */	

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
				
		String pathInfo = request.getPathInfo(); //
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			DepartamentoDAO depDAO = new DepartamentoDAOImpl();
			
			//GET 
			//	/departamentos/
			//	/departamentos
			
			request.setAttribute("listaDepartamentos", depDAO.getNumerosEmp());
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos.jsp");
			        		       
		} else {
			// GET
			// 		/departamentos/{id}
			// 		/departamentos/{id}/
			// 		/departamentos/edit/{id}
			// 		/departamentos/edit/{id}/
			// 		/departamentos/create
			// 		/departamentos/create/
			
			pathInfo = pathInfo.replaceAll("/$", "");
			String[] pathParts = pathInfo.split("/");
			
			if (pathParts.length == 2 && "crear".equals(pathParts[1])) {
				
				DepartamentoDAO depDAO = new DepartamentoDAOImpl();
				
				// GET
				// /departamentos/create	
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/crear-departamento.jsp");
        												
			
			} else {
				
				System.out.println("Opción POST no soportada.");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamentos.jsp");
			
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
			DepartamentoDAO depDAO = new DepartamentoDAOImpl();
			
			String nombre = request.getParameter("nombre");
			Double presupuesto = Double.parseDouble(request.getParameter("presupuesto"));
			Double gastos = 0.0;
			
			Departamento nuevoDep = new Departamento();
			nuevoDep.setNombre(nombre);
			nuevoDep.setPresupuesto(presupuesto);
			nuevoDep.setGastos(gastos);
			depDAO.create(nuevoDep);			
			
		} else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {			
			// Actualizar uno existente
			//Dado que los forms de html sólo soportan method GET y POST utilizo parámetro oculto para indicar la operación de actulización PUT.
			doPut(request, response);
			
		
		} else {
			
			System.out.println("Opción POST no soportada.");
			
		}
		
		response.sendRedirect("/web_empleados/departamentos");
		//response.sendRedirect("/tienda_informatica/departamentos");
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DepartamentoDAO depDAO = new DepartamentoDAOImpl();
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		String presupuesto = request.getParameter("presupuesto");
		Departamento dep = new Departamento();
		
		try {
			
			int id = Integer.parseInt(codigo);
			dep.setCodigo(id);
			dep.setNombre(nombre);
			dep.setPresupuesto(Double.parseDouble(presupuesto));
			depDAO.update(dep);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}

}
