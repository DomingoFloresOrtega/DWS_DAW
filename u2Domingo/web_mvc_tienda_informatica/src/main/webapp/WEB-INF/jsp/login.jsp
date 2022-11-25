<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Fabricante"%>
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
	<form action="/tienda_informatica/usuarios/login/" method="post">
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Login</h1>
			</div>
		</div>
		
		<div class="clearfix">
			<hr/>
		</div>
		
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: none;width: auto;overflow: hidden;">
				<input hidden name="__method__" value="xlogin" />
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				Usuario
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="user" />
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 50%">
				Contraseña
			</div>
			<div style="float: none;width: auto;overflow: hidden;">
				<input name="pass" />
			</div> 
		</div>
		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: none;width: auto;overflow: hidden;">
				<input type="submit" />
			</div> 
		</div>

	</form>
</div>
<%@ include file ="/WEB-INF/jsp/footer.jspf"%>

</body>
</html>