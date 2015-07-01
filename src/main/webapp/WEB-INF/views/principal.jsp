<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
		function borraPrincipal(id,cantidad)
		{
			if(cantidad>0){
				alert("Existen datos asociados");
				return;
			}
		document.location="borraPrincipal.html?id="+id;
		}
		
		function modificaPrincipal(id)
		{
		 document.location="modificaPrincipal.html?id="+id;	
		}
</script>






</head>
<body>
	<%@include file="navegador.jsp"%>
	<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Principales<small>JSP</small>
			</h1>
		</div>
	</div>
	</header>

	<div class="container">
		<div class="row">
			<h1>Principales</h1>
			<table id="miTabla" class="table table-striped">
				<tr>
					<th>ID</th>
					<th>TITULO</th>
					<th>TEXTO</th>
					<th>IMAGEN</th>
					<th>CONTENIDO</th>
					<th>ACCIONES</th>
				</tr>

				<c:forEach items="${principales}" var="principale">
					<tr>
						<td>${principale.id}</td>
						<td>${principale.titulo}</td>
						<td>${principale.texto}</td>
						<td>${principale.imagene.id}</td>
						<td>${principale.contenido.descripcion}</td>
						<td><input type="button" value="Modificar"		class="btn btn-primary"					onclick="modificaPrincipal(${principale.id})"> 
						<input							type="button" value="Borrar"	class="btn btn-warning"						onclick="borraPrincipal(${principale.id})"></td>
					</tr>
				</c:forEach>
			</table>
			<input type="button" value=" + A�adir" class="btn btn-success" onclick="modificaPrincipal(0)">
		</div>
	</div>
</body>
</html>