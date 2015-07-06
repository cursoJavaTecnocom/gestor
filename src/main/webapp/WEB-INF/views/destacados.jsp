<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>DESTACADOS</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/contenido.js" type="text/javascript"></script>
<script type="text/javascript">
	function borraDestacado(id){
		if(confirm("Está seguro de borar el destacado?"))
	    {
			document.location="borraDestacado.html?id="+id;
	    }
	}
	
	function modificaDestacado(id){
		document.location="modificaDestacado.html?id="+id;
	}

	function verDestacado(id)
	{
		document.location="verDestacado.html?id="+id;
	}
</script>

</head>
<body>
	<%@include file="navegador.jsp"%>
	<header>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span> Destacados
				</h1>
			</div>
		</div>
	</header>
	
<div class="container">
	<table class="table table-striped">
		
		<tr>
			<th>ID</th>
			<th>TÍTULO</th>
			<th>TEXTO</th>
			<th>DESCRIPCIÓN CONTENIDO</th>
			<th>ACCIÓN</th>
		</tr>
		
		<c:if test="${empty destacados}">
			<tr>
				<td colspan="5">
					La tabla está vacía en éstos momentos. Añada un destacado.
				</td>
			</tr>
		</c:if>
		<c:if test="${not empty destacados }">
			<c:forEach items="${destacados}" var="destacado">
				<tr>
					<td>${destacado.id}</td>
					<td>${destacado.titulo}</td>
					<td>${destacado.texto}</td>
					<td>${destacado.contenido.descripcion}</td>
					<td>
						<input type="button" class="btn btn-warning" value="Borrar" onclick="borraDestacado(${destacado.id})">
						<input type="button" class="btn btn-primary" value="Modificar" onclick="modificaDestacado(${destacado.id})">
						<input type="button" class="btn btn-success" value="Ver"  onclick="verDestacado(${destacado.id})">
					</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td colspan="5">
				<input type="button" class="btn btn-success" value="Nuevo Destacado"  onclick="modificaDestacado(0)">
			</td>
		</tr>	
				
	</table>
</div>
</body>
</html>

