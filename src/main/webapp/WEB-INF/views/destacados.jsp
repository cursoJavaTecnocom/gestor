<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Destacados</h1>
	<table border="1">
		
		<tr>
			<th>T&iacute;tulo</th>
			<th>Modificar</th>
			<th>Acci&oacute;n</th>
		</tr>
		
		<c:forEach items="${destacados}" var="destacado">
			<tr>
				<td>${destacado.titulo}</td>
				<td>${destacado.texto}</td>
				<td>
					<input type="button" value="Borrar" onclick="borraDestacado(${destacado.id})">
					<input type="button" value="Modificar" onclick="modificaDestacado(${destacado.id})">
					<input type="button" value="Ver" onclick="">
				</td>
			</tr>
		</c:forEach>	
				
	</table>
	
</body>
</html>