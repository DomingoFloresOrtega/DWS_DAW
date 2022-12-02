<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="examen.domingo.model.Departamento"%>
<%@page import="examen.domingo.dao.DepDTO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jsp/header.jspf" %>

<%@ include file="/WEB-INF/jsp/nav.jspf" %>
<head>
<meta charset="UTF-8">
<title>Departamentos</title>
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
				<h1>Departamentos</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 10%; top : 39%;">
					
						<form action="/web_empleados/departamentos/crear">
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
			<div style="float: left;width: 15%">Nombre</div>
			<div style="float: left;width: 15%">Presupuesto</div>
			<div style="float: left;width: 15%">Gastos</div>
			<div style="float: left;width: 15%">Empleados</div>
			<div style="float: none;width: auto;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<% 
        if (request.getAttribute("listaDepartamentos") != null) {
            List<DepDTO> listaDepartamento = (List<DepDTO>)request.getAttribute("listaDepartamentos");
            
            for (DepDTO departamento : listaDepartamento) {
            	
            	if (departamento.getCodigo() != 0){
    %>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 15%"><%= departamento.getCodigo()%></div>
			<div style="float: left;width: 15%"><%= departamento.getNombre()%></div>
			<div style="float: left;width: 15%"><%= departamento.getPresupuesto()%></div>
			<div style="float: left;width: 15%"><%= departamento.getGastos()%></div>
			<div style="float: left;width: 15%"><%= departamento.getNumEmpleados()%></div>
			<div style="float: none;width: auto;overflow: hidden;">
				<form action="/web_empleados/departamentos/<%= departamento.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Ver Detalle" />
				</form>
				<form action="/web_empleados/departamentos/editar/<%= departamento.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Editar" />
				</form>
				<form action="/web_empleados/departamentos/borrar/" method="post" style="display: inline;">
					<input type="hidden" name="__method__" value="delete"/>
					<input type="hidden" name="codigo" value="<%= departamento.getCodigo()%>"/>
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
		No hay registros de departamentos
	<% } %>
	</div>
	<%@ include file ="/WEB-INF/jsp/footer.jspf"%>
</body>
</body>
</html>