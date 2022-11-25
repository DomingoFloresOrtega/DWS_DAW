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
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Detalle Usuario</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">
					
						<form action="/tienda_informatica/usuarios" >
							<input type="submit" value="Volver" />
						</form>
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
				<input value="<%= optUser.get().getCodigo() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Usuario</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input value="<%= optUser.get().getUser() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Contraseña</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input value="<%= optUser.get().getPass() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Rol</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input value="<%= optUser.get().getRol() %>" readonly="readonly"/>
			</div> 
		</div>
		
		<% 	} else { %>
			
				request.sendRedirect("usuarios/");
		
		<% 	} %>
		
</div>
<%@ include file ="/WEB-INF/jsp/footer.jspf"%>

</body>
</html>