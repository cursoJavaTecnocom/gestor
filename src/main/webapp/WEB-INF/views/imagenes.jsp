<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="js/imagenes.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Imagenes
			</h1>
		</div>
	</div>
	</header>
	<div class="container">
		<div class="row">
			<input type="button" value=" Nueva Imagen" class="btn btn-success" onclick="modificaImagen(0)">
			<table border="1" id="miTabla" class="table table-striped">

				<tr>
					<td>id</td>
					<td>nombre</td>
					<td>imagen</td>
					<td>Acciones</td>
					
				</tr>
				<c:forEach items="${imagenes}" var="imagen">
					<tr>
						<td>${imagen.id }</td>
						<td>${imagen.nombre }
						
						</td>
						<td><img src="images/${imagen.nombre }" width="100" height="100"></td>
						<td><input type="button" value="Borrar"
							class="btn btn-warning" onclick="borraImagen(${imagen.id })">
						<input type="button" value="Modificar"
							class="btn btn-primary" onclick="modificaImagen(${imagen.id})"></td>
					</tr>
				</c:forEach>
			</table>
			<br>
						<font
						color="#ff0000">
					
						<sp:errors path="imagenes">
							</sp:errors></font>
		</div>
</body>
</html>