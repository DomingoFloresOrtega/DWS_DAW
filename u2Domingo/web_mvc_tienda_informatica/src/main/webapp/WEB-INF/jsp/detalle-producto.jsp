<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Producto"%>
<%@page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jsp/header.jspf" %>

<%@ include file="/WEB-INF/jsp/nav.jspf" %>
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
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Detalle Producto</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">
					
						<form action="/tienda_informatica/productos" >
							<input type="submit" value="Volver" />
						</form>
					</div>
				
			</div>
		</div>
		
		<div class="clearfix">
			<hr/>
		</div>
		
		<% 	Optional<Producto> optPro = (Optional<Producto>)request.getAttribute("producto");
			if (optPro.isPresent()) {
		%>
		
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Código</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input value="<%= optPro.get().getCodigo() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Nombre</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input value="<%= optPro.get().getNombre() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Precio</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input value="<%= optPro.get().getPrecio() %>" readonly="readonly"/>
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				<label>Codigo de fabricante</label>
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input value="<%= optPro.get().getCodigoFabricante() %>" readonly="readonly"/>
			</div> 
		</div>
		
		<% 	} else { %>
			
				request.sendRedirect("productos/");
		
		<% 	} %>
		
</div>
<%@ include file ="/WEB-INF/jsp/footer.jspf"%>

</body>
</html>