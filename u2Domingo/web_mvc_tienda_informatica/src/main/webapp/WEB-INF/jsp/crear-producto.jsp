<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Fabricante"%>
<%@page import="org.iesvegademijas.model.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Fabricante</title>
<style>
.clearfix::after {
	content: "";
	display: block;
	clear: both;
}

</style>
</head>
<body>

<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
	<form action="/tienda_informatica/productos/crear/" method="post">
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Crear Producto</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">								
					<input type="submit" value="Crear"/>					
				</div>
				
			</div>
		</div>
		
		<div class="clearfix">
			<hr/>
		</div>
		
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 25%">
				Nombre
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="nombre" />
			</div> 
			<div style="float: left;width: 25%">
				Precio
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="precio" />
			</div> 
			<div style="float: left;width: 25%">
				Codigo de fabricante
			</div>
			<div style="float: none;width: auto;overflow: hidden;">

		<div style="margin-top: 6px;" class="clearfix">
			<select name="codigo_fabricante">
			<%
	            
				List<Producto> listaProducto = (List<Producto>)request.getAttribute("listaProductos");
				
	            for (Producto p : listaProducto) {
    		%>
				<option value="<%=p.getCodigoFabricante() %>"><%=p.getNombre_fab() %></option>
			<% 
            	}
  			%>
			</select>
		</div>
	
			</div> 
		</div>

	</form>
</div>

</body>
</html>