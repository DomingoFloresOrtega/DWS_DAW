<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Producto"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
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
				<h1>Productos</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 10%; top : 39%;">
					
						<form action="/tienda_informatica/productos/crear">
							<input type="submit" value="Crear">
						</form>
					</div>
					
					<div style="position: absolute; left: 45%; top : 39%;">
					
						<form action="/tienda_informatica/productos">
							<input type="text" name="filtar-por-texto"/>
							<input type="submit" value="Buscar">
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
			<div style="float: left;width: 25%">Precio</div>
			<div style="float: none;width: auto;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<% 
        if (request.getAttribute("listaProductos") != null) {
            List<Producto> listaProducto = (List<Producto>)request.getAttribute("listaProductos");
            
            for (Producto productos : listaProducto) {
            	
            	if (productos.getCodigo() != 0){
    %>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 25%"><%= productos.getCodigo()%></div>
			<div style="float: left;width: 25%"><%= productos.getNombre()%></div>
			<div style="float: left;width: 25%"><%= productos.getPrecio()%></div>
			<div style="float: none;width: auto;overflow: hidden;">
				<form action="/tienda_informatica/productos/<%= productos.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Ver Detalle" />
				</form>
				<form action="/tienda_informatica/productos/editar/<%= productos.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Editar" />
				</form>
				<form action="/tienda_informatica/productos/borrar/" method="post" style="display: inline;">
					<input type="hidden" name="__method__" value="delete"/>
					<input type="hidden" name="codigo" value="<%= productos.getCodigo()%>"/>
    				<input type="submit" value="Eliminar" />
				</form>
			</div>
		</div>
		
		<%
            	}
            	else {
            		
            	}
		%>

	<% 
            }
        } else { 
    %>
		No hay registros de productos
	<% } %>
	</div>
</body>
</body>
</html>