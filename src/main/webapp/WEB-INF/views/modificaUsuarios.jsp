<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/usuariosjs.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty usuarios.id}">
		<h1>Modificación de Usuario</h1>
	</c:if>
	<c:if test="${empty usuarios.id}">
		<h1>Alta de nuevo Usuario</h1>
	</c:if>

	<sp:form action="grabaUsuario.gin" modelAttribute="usuario">
		<sp:hidden path="id" />
		<table>
			<tr>
				<td>Usuario</td>
				<td><sp:input path="usuario" /></td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td><sp:input path="clave" /></td>
			</tr>
		</table>
		<tr>
			<td><input type="submit" value="grabar">
		</tr>
	</sp:form>
</body>
</html>