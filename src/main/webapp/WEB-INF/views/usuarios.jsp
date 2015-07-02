<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="js/usuariosjs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%@include file="navegador.jsp"%>
	<header>
	<div class="jumbotron">
		<div class="container">
			<h1 style= "text-shadow: 5px 5px 20px #6F8C84";>
				<span class="glyphicon glyphicon-user" aria-hidden="true" id="tituloh1"  ></span>Usuarios
			</h1>
		</div>
	</div>  
	</header>
	<div class="container">
		<div class="row">
			<table id="miTabla" class="table table-striped">
				<tr>
					<th>Usuario</th>
					<th>Clave</th>
					<th>Acciones</th>
				</tr>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.usuario}</td>
						<td>${usuario.clave }</td>
						<td><input  id="vueltas" type="button" value="Borrar"							class="btn btn-warning" onclick="borraUsuario(${usuario.id})">
							<input  id="vueltas" type="button" value="Modificar"							class="btn btn-primary" onclick="modificaUsuario(${usuario.id})">
						</td>
					</tr>
				</c:forEach>
			</table>
			<input id="vueltas" type="button" value="+ Nuevo Usuario" class="btn btn-success" onclick="modificaUsuario(0)">

		</div> 
		
</body>
</html>