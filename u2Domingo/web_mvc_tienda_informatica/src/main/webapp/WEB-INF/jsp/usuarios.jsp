<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Usuario"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jsp/header.jspf" %>

<%@ include file="/WEB-INF/jsp/nav.jspf" %>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
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
				<h1>Usuarios</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 10%; top : 39%;">
					
						<form action="/tienda_informatica/usuarios/crear">
							<input type="submit" value="Crear">
						</form>
					</div>
				
			</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
		<div class="clearfix">
			<div style="float: left;width: 20%">Código</div>
			<div style="float: left;width: 20%">Usuario</div>
			<div style="float: left;width: 20%">Contraseña</div>
			<div style="float: left;width: 20%">Rol</div>
			<div style="float: none;width: auto;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<% 
        if (request.getAttribute("listaUsuarios") != null) {
            List<Usuario> listaUsuario = (List<Usuario>)request.getAttribute("listaUsuarios");
            
            for (Usuario usuarios : listaUsuario) {
            	
            	if (usuarios.getCodigo() != 0){
    %>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 20%"><%= usuarios.getCodigo()%></div>
			<div style="float: left;width: 20%"><%= usuarios.getUser()%></div>
			<div style="float: left;width: 20%"><%= usuarios.getPass()%></div>
			<div style="float: left;width: 20%"><%= usuarios.getRol()%></div>
			<div style="float: none;width: auto;overflow: hidden;">
				<form action="/tienda_informatica/usuarios/<%= usuarios.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Ver Detalle" />
				</form>
				<form action="/tienda_informatica/usuarios/editar/<%= usuarios.getCodigo()%>" style="display: inline;">
    				<input type="submit" value="Editar" />
				</form>
				<form action="/tienda_informatica/usuarios/borrar/" method="post" style="display: inline;">
					<input type="hidden" name="__method__" value="delete"/>
					<input type="hidden" name="codigo" value="<%= usuarios.getCodigo()%>"/>
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