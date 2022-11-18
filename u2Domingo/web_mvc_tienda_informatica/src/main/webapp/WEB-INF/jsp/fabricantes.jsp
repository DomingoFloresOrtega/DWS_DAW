<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Fabricante"%>
<%@page import="org.iesvegademijas.dao.FabDTO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fabricantes</title>
<style>
.clearfix::after {
	content: "";
	display: block;
	clear: both;
}

</style>
</head>
<body>
<body>

	<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Fabricantes</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">
					
						<form action="/tienda_informatica/fabricantes/crear">
							<input type="submit" value="Crear">
						</form>
						
					</div>
					
				<div style="position: absolute; left: 55%; top : 39%;">
					
						<form action="/tienda_informatica/fabricantes">
							<input type="submit" value="Ordenar">
						</form>
						
					</div>
					
					<div style="position: absolute; left: 55%; top : 39%;">
					
						<form action="/tienda_informatica/fabricantes">
							<select name="ordenar-por">
								<option value="codigo" <% if (request.getParameter("ordenar-por") != null && request.getParameter("ordenar-por").equals("codigo") ) {%>
								selected="selected"<% } %>>Codigo</option>
								<option value="nombre" <% if (request.getParameter("ordenar-por") != null && request.getParameter("ordenar-por").equals("nombre")) {%>
								selected="selected"<% } %>>Nombre</option>
							</select>
							
							<select name="modo-ordenar">
								<option value="ASC" <% if (request.getParameter("modo-ordenar") != null && request.getParameter("modo-ordenar").equals("ASC")) {%>
								selected<% } %>>Ascendente</option>
								<option value="DESC" <% if (request.getParameter("modo-ordenar") != null && request.getParameter("modo-ordenar").equals("DESC")) {%>
								selected<% } %>>Descendente</option>
							</select>
							<input type="submit" value="Ordenar">
						</form>
						
					</div>
				
			</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
		<div class="clearfix">
			<div style="float: left;width: 25%">Código</div>
			<div style="float: left;width: 25%">Nombre</div>
			<div style="float: left;width: 25%">Productos</div>
			<div style="float: none;width: auto;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<% 
        if (request.getAttribute("listaFabricantes") != null) {
            List<FabDTO> listaFabricante = (List<FabDTO>)request.getAttribute("listaFabricantes");
            
            for (FabDTO fabricante : listaFabricante) {
    %>

		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 25%"><%= fabricante.getCodigo()%></div>
			<div style="float: left;width: 25%"><%= fabricante.getNombre()%></div>
			<div style="float: left;width: 25%"><%= fabricante.getNumProductos() %></div>
		
			<div style="float: none;width: auto;overflow: hidden;">
				<form action="/tienda_informatica/fabricantes/<%= fabricante.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Ver Detalle" />
				</form>
				<form action="/tienda_informatica/fabricantes/editar/<%= fabricante.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Editar" />
				</form>
				<form action="/tienda_informatica/fabricantes/borrar/" method="post" style="display: inline;">
					<input type="hidden" name="__method__" value="delete"/>
					<input type="hidden" name="codigo" value="<%= fabricante.getCodigo()%>"/>
    				<input type="submit" value="Eliminar" />
				</form>
			</div>
		</div>

	<% 
            }
        } else { 
    %>
		No hay registros de fabricante
	<% } %>
	</div>
</body>
</body>
</html>