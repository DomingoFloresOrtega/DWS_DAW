<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Usuario"%>
<%@page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jsp/header.jspf" %>

<%@ include file="/WEB-INF/jsp/nav.jspf" %>
<head>
<meta charset="UTF-8">
<title>Detalle Usuario</title>
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
	<form action="/tienda_informatica/usuarios/editar/" method="post" >
		<input type="hidden" name="__method__" value="put" />
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Editar Usuario</h1>
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
		
		<% 	Optional<Usuario> optUser = (Optional<Usuario>)request.getAttribute("usuario");
			if (optUser.isPresent()) {
		%>
		
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Código</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="codigo" value="<%= optUser.get().getCodigo() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Usuario</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="user" value="<%= optUser.get().getUser() %>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Contraseña</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="pass" value="<%= optUser.get().getPass() %>"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				Rol
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<select name="rol">
					<option value="administrador" <% if (optUser.get().getRol() != null && optUser.get().getRol().equals("administrador") ) {%>
								selected="selected"<% } %>>Administrador</option>
					<option value="cliente" <% if (optUser.get().getRol() != null && optUser.get().getRol().equals("cliente") ) {%>
								selected="selected"<% } %>>Cliente</option>
					<option value="vendedor" <% if (optUser.get().getRol() != null && optUser.get().getRol().equals("vendedor") ) {%>
								selected="selected"<% } %>>Vendedor</option>
				</select>
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