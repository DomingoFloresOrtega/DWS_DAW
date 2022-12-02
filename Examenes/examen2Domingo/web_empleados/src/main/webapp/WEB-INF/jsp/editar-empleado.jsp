<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="examen.domingo.model.Empleado"%>
<%@page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jsp/header.jspf" %>

<%@ include file="/WEB-INF/jsp/nav.jspf" %>
<head>
<meta charset="UTF-8">
<title>Detalle Empleado</title>
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
	<form action="/web_empleados/empleados/editar/" method="post" >
		<input type="hidden" name="__method__" value="put" />
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Editar Empleado</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">
							<input type="submit" value="Guardar" />						
				</div>
				
			</div>
		</div>
		
		<div class="clearfix">
			<hr/>
		</div>
		
		<% 	Optional<Empleado> optEmp = (Optional<Empleado>)request.getAttribute("empleado");
			if (optEmp.isPresent()) {
		%>
		
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Código</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="codigo" value="<%= optEmp.get().getCodigo() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>NIF</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="nif" value="<%= optEmp.get().getNif() %>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Nombre</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="nombre" value="<%= optEmp.get().getNombre() %>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Apellido 1</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="apellido1" value="<%= optEmp.get().getApellido1() %>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Apellido 2</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="apellido2" value="<%= optEmp.get().getApellido2() %>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Departamento</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="id_depto" value="<%= optEmp.get().getCod_dept() %>"/>
			</div> 
		</div>
		
		
		<% 	} else { %>
			
				request.sendRedirect("usuarios/");
		
		<% 	} %>
	</form>
</div>
<%@ include file ="/WEB-INF/jsp/footer.jspf"%>

</body>
</html>