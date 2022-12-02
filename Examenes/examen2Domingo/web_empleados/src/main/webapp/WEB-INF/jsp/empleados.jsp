<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="examen.domingo.model.Empleado"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jsp/header.jspf" %>

<%@ include file="/WEB-INF/jsp/nav.jspf" %>
<head>
<meta charset="UTF-8">
<title>Empleados</title>
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
				<h1>Empleados</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 10%; top : 39%;">
					
						<form action="/web_empleados/empleados/crear">
							<input type="submit" value="Crear">
						</form>
					</div>
				
			</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
		<div class="clearfix">
			<div style="float: left;width: 15%">Código</div>
			<div style="float: left;width: 15%">NIF</div>
			<div style="float: left;width: 15%">Nombre</div>
			<div style="float: left;width: 15%">Apellido 1</div>
			<div style="float: left;width: 15%">Apellido 2</div>
			<div style="float: none;width: auto;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<% 
        if (request.getAttribute("listaEmpleados") != null) {
            List<Empleado> listaEmpleado = (List<Empleado>)request.getAttribute("listaEmpleados");
            
            for (Empleado empleados : listaEmpleado) {
            	
            	if (empleados.getCodigo() != 0){
    %>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 15%"><%= empleados.getCodigo()%></div>
			<div style="float: left;width: 15%"><%= empleados.getNif()%></div>
			<div style="float: left;width: 15%"><%= empleados.getNombre()%></div>
			<div style="float: left;width: 15%"><%= empleados.getApellido1()%></div>
			<div style="float: left;width: 15%"><%= empleados.getApellido2()%></div>
			<div style="float: none;width: auto;overflow: hidden;">
				<form action="/web_empleados/empleados/<%= empleados.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Ver Detalle" />
				</form>
				<form action="/web_empleados/empleados/editar/<%= empleados.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Editar" />
				</form>
				<form action="/web_empleados/empleados/borrar/" method="post" style="display: inline;">
					<input type="hidden" name="__method__" value="delete"/>
					<input type="hidden" name="codigo" value="<%= empleados.getCodigo()%>"/>
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
	<%@ include file ="/WEB-INF/jsp/footer.jspf"%>
</body>
</body>
</html>