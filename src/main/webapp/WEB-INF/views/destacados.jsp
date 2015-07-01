<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<title>DESTACADOS</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">


function borraDestacado(id){
	document.location="borraDestacado.html?id="+id;
}

function modificaDestacado(id){
	document.location="modificaDestacado.html?id="+id;
}



</script>

</head>
<body>
	<%-- <jsp:include page="seguridad.jsp"></jsp:include> --%>
	<h1>Destacados</h1>
	
<div class="container">
	<!-- <br><a href="modificaDestacado.html?id=0">Alta de Destacados</a> -->
	<table class="table table-striped">
		
		<tr>
			<th>ID</th>
			<th>TÍTULO</th>
			<th>TEXTO</th>
			<th>ID CONTENIDO</th>
			<th>ACCIÓN</th>
		</tr>
		
		<c:forEach items="${destacados}" var="destacado">
			<tr>
				<td>${destacado.id}</td>
				<td>${destacado.titulo}</td>
				<td>${destacado.texto}</td>
				<td>${destacado.contenido.id}</td>
				<td>
					<input type="button" class="btn btn-warning" value="Borrar" onclick="borraDestacado(${destacado.id})">
					<input type="button" class="btn btn-primary" value="Modificar" onclick="modificaDestacado(${destacado.id})">
					<input type="button" class="btn btn-success" value="Ver" onclick="">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<input type="button" class="btn btn-success" value="Nuevo Destacado"  onclick="modificaDestacado(0)">
			</td>
		</tr>	
				
	</table>
</div>
</body>
</html>
