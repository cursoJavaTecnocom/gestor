<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/usuariosjs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<header>Usuarios</header>
	<a href="modificaUsuario.html?id=0">Alta Nuevo Usuario</a>
	<table border="1">

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
				<td><input type="button" value="Borrar" onclick="borraUsuario(${usuario.id})"></td>
				<td><input type="button" value="Modificar" onclick="modificaUsuario(${usuario.id})"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>