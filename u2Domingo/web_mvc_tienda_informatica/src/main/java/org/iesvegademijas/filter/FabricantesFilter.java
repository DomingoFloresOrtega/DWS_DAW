package org.iesvegademijas.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesvegademijas.model.Usuario;

/**
 * Servlet Filter implementation class UsuariosFilter
 */
@WebFilter(
		urlPatterns = { "/fabricantes/*" }, 
		initParams = { 
				@WebInitParam(name = "acceso-concedido-a-rol", value = "administrador")
		})
public class FabricantesFilter extends HttpFilter implements Filter {
    
	private String rolAcceso;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FabricantesFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		//Cast de ServletRequest a HttpServletRequest, el único tipo implementado 
		//en el contenedor de Servlet: HttpServletRequest & HttpServletReponse
		HttpServletRequest httpRequest =(HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		
		//Accediendo al objeto de sesión
		HttpSession session = httpRequest.getSession();
		
		//Obteniendo la url
		String url = httpRequest.getRequestURL().toString();
		
		Usuario usuario = null;
		
		if (session != null //Seteo inline de usuario
				&& (usuario = (Usuario)session.getAttribute("usuario") )!= null
				&& "administrador".equals(usuario.getRol())) {
			
			//Si eres administrador acceso a cualquier página del filtro
			chain.doFilter(request, response);
			return;
			
		} else if (url.endsWith("/fabricantes/crear") 
						|| url.contains("/fabricantes/editar")) {
			
			// Usuario no administrador trata de acceder a páginas de crear y editar, y el filtro lo redirige a login
			httpResponse.sendRedirect("/tienda_informatica/usuarios/login");
			return;
			
		} else {
			
			// Otras rutas /fabricantes y /fabricantes/{id} se dan paso a cualquier rol
			
			//RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/WEB-INF/jsp/fabricantes.jsp");
			//dispatcher.forward(httpRequest, httpResponse);
			chain.doFilter(request, response);
			return;
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.rolAcceso = fConfig.getInitParameter("acceso-concedido-a-rol");
		
	}

}