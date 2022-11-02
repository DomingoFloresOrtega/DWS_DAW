<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Fabricante"%>
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
				
			</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
		<div class="clearfix">
			<div style="float: left;width: 33%">Código</div>
			<div style="float: left;width: 33%">Nombre</div>
			<div style="float: none;width: auto;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<% 
        if (request.getAttribute("listaFabricantes") != null) {
            List<Fabricante> listaFabricante = (List<Fabricante>)request.getAttribute("listaFabricantes");
            
            for (Fabricante fabricante : listaFabricante) {
    %>

		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 33%"><%= fabricante.getCodigo()%></div>
			<div style="float: left;width: 33%"><%= fabricante.getNombre()%></div>
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