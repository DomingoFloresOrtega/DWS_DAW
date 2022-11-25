package org.iesvegademijas.servlet;

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

import org.iesvegademijas.dao.FabDTO;
import org.iesvegademijas.dao.FabricanteDAO;
import org.iesvegademijas.dao.FabricanteDAOImpl;
import org.iesvegademijas.dao.UsuarioDAO;
import org.iesvegademijas.dao.UsuarioDAOImpl;
import org.iesvegademijas.model.Fabricante;
import org.iesvegademijas.model.Producto;
import org.iesvegademijas.model.Usuario;

@WebServlet(name = "UsuariosServlet", urlPatterns = { "/usuarios/*" })
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
			
		if (pathInfo == null || "/".equals(pathInfo)) {
			UsuarioDAO uDAO = new UsuarioDAOImpl();
			
			//GET 
			//	/usuarios/
			//	/usuarios
			
			List<Usuario> listaFiltro = uDAO.getAll();
			
			List<Usuario> lista = listaFiltro.stream().collect(toList());
			
			
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
        												
			
			} else if (pathParts.length == 2 && "login".equals(pathParts[1]) ) {
				UsuarioDAO uDAO = new UsuarioDAOImpl();
				
				// GET
				// /usuarios/login
				try {
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");  								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
				}
				
				
			} else if (pathParts.length == 2) {
				UsuarioDAO uDAO = new UsuarioDAOImpl();
				// GET
				// /usuarios/{id}
				try {
					request.setAttribute("usuario",uDAO.find(Integer.parseInt(pathParts[1])));
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detalle-usuario.jsp");
					        								
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp");
				}
				
			} else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
				UsuarioDAO uDAO = new UsuarioDAOImpl();
				
				// GET
				// /usuarios/edit/{id}
				try {
					request.setAttribute("usuario",uDAO.find(Integer.parseInt(pathParts[2])));
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
			UsuarioDAO uDAO = new UsuarioDAOImpl();
			
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String rol = request.getParameter("rol");
			Usuario nuevoUser = new Usuario();
			nuevoUser.setUser(user);
			try {
				nuevoUser.setPass(hashPassword(pass));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			nuevoUser.setRol(rol);
			// Comprobacion de codigo valido
			if (user != "" && pass != "") {
				uDAO.create(nuevoUser);
			}		
			
		} else if (__method__.equals("xlogin")) {
			UsuarioDAO uDAO = new UsuarioDAOImpl();
			for (int i = 0; i < uDAO.getAll().size(); i++) {
				try {
					if (request.getParameter("user").equals(uDAO.getAll().get(i).getUser()) 
							&& hashPassword(request.getParameter("pass")).equals(uDAO.getAll().get(i).getPass())
							&& uDAO.getAll().get(i).getRol() == "administrador") {
						String bin = uDAO.getAll().get(i).getPass();
						
						
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
		
		UsuarioDAO uDAO = new UsuarioDAOImpl();
		String codigo = request.getParameter("codigo");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String rol = request.getParameter("rol");
		Usuario u = new Usuario();
		
		try {
			
			int id = Integer.parseInt(codigo);
			u.setCodigo(id);
			u.setUser(user);
			u.setPass(hashPassword(pass));
			u.setRol(rol);
			uDAO.update(u);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		UsuarioDAO uDAO = new UsuarioDAOImpl();
		String codigo = request.getParameter("codigo");
		
		try {
			
			int id = Integer.parseInt(codigo);
		
		uDAO.delete(id);
			
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
	}
	
	/**
	 * Método que obtiene el hash de una password, por ejemplo, dado password = admin, devuelve:          
8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
	 * @param password
	 * @return hash de encriptación de la password
	 * @throws NoSuchAlgorithmException
	 */
	public static String hashPassword(String password ) throws NoSuchAlgorithmException {
		MessageDigest digest;
		
		digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
				password.getBytes(StandardCharsets.UTF_8));
		
		return bytesToHex(encodedhash);					
		
	}
	
	private static String bytesToHex(byte[] byteHash) {
		
	    StringBuilder hexString = new StringBuilder(2 * byteHash.length);	  	
	    for (int i = 0; i < byteHash.length; i++) {
	        String hex = Integer.toHexString(0xff & byteHash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    
	    return hexString.toString();
	    
	}

	
}
