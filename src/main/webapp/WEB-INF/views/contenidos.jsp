<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CONTENIDO</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/contenido.js" type="text/javascript"></script>
</head>
<body>
<header>
		<div class="jumbotron">
			<div class="container"><h1><span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Contenidos<small>JSP</small></h1></div>
		</div>
</header>


	<table border="2" class="table table-striped">
		
		<tr>
			<td>ID</td>
			<td>CONTENIDO</td> 
			<td>DESCRIPCION</td>
			<td>ACCIONES</td>
		</tr>
		<c:forEach items="${contenidos}" var="contenido">
			<tr>
				<td>${contenido.id }</td>
				<td>${contenido.contenido }</td>
				<td>${contenido.descripcion }</td>
				<td>
				<input type="button" value="Modificar"  class="btn btn-primary" onclick="modificaContenido(${contenido.id},'modificaContenido.html')"> 
				<input type="button" value="Borrar"	class="btn btn-warning" onclick="borraContenido(${contenido.id})">
				<!-- <input type="button" value="Previsualización" onclick="verContenido"> -->
				</td>
			</tr>
		</c:forEach>
	
		<tr>
			<a href="modificaContenido.html?id=0"><input type="button" value=" + Añadir" class="btn btn-success"></a>
		</tr>
</table>
</body>
</html>