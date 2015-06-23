<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>

<table border="2" id="miTabla">

	<tr>
		<td>ID</td>
		<td>TITULO</td>
		<td>TEXTO</td>
		<td>IMAGEN</td>
		<td>CONTENIDO</td>
	</tr>
	
	<c:forEach items="${principales}" var="principal">
	
	<tr>
		<td>${principale.id}</td>
		<td>${principale.titulo}</td>
		<td>${principale.texto}</td>
		<td>${principale.imagene.id}</td>
		<td>${principale.contenido.descripcion}</td>
		<td>
			<input type="button" value="Modificar" >			
			<input type="button" value="Borrar" >
		</td>
	</tr>
	
	<tr>
	<td></td>
	</tr>


	</c:forEach>
</table>
<a href="modificaPrincipal.gin?id=0">Nuevo Principal</a>



</body>
</html>