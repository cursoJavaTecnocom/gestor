<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="js/usuariosjs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Usuarios
			</h1>
		</div>
	</div>
	</header>
	<div class="container">
		<div class="row">
			<a href="modificaUsuario.html?id=0">Alta Nuevo Usuario</a>
			<table border="1" id="miTabla" class="table table-striped">

				<tr>
					<td>id</td>
					<td>clave</td>
					<td>usuario</td>
				</tr>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.id }</td>
						<td>${usuario.clave }</td>
						<td>${usuario.usuario}</td>
						<td><input type="button" value="Borrar"
							class="btn btn-warning" onclick="borraUsuario(${usuario.id})"></td>
						<td><input type="button" value="Modificar"
							class="btn btn-primary" onclick="modificaUsuario(${usuario.id})"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>