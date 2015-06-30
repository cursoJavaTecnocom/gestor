<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Validacion</title>
</head>
<body>
	<h1>Loggin</h1>
	<sp:form action="validacion.html" modelAttribute="usuario">
		<table>
			<tr>
				<td>Usuario:</td>
				<td><sp:input path="usuario"/></td>
			</tr>
			<tr>
				<td>Clave</td>
				<td><sp:input path="clave"/></td>
			</tr>


		</table>
		<input type="submit" value="validar">
	</sp:form>
	
</body>
</html>

