<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Noticias</title>
	
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery-2.1.4.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/jsnoticias.js" type="text/javascript"></script>
</head>
<body>

	<header>
		<div class="jumbotron">
			<div class="container"><h1><span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Noticias<small>JSP</small></h1></div>
		</div>
	</header>
	
	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="well well-lg">
					  <h1>Noticias</h1>
						<table id="miTabla" class="table table-striped">
						<tr>
							<th>id</th>
							<th>Fecha</th>
							<th>Titulo</th>
							<th>Texto</th>
							<th>Contenido</th>
							<th>Acción</th>
						</tr>
						<c:forEach items="${noticias}" var="noticia">
							<tr>
								<td>${noticia.id }</td>
								<td>${noticia.fecha}</td>
								<td>${noticia.titulo}</td>
								<td>${noticia.texto}</td>
								<td>${noticia.idContenido}</td>
								<td><input type="button" value="Modificar" class="btn btn-primary" onclick="modificaNoticia(${noticia.id})">
									<input type="button" value="Borrar" class="btn btn-warning" onclick="borraNoticia(${noticia.id})">
								</td>
							</tr>
						</c:forEach>
					</table>	
					<input type="button" value=" + Añadir" class="btn btn-success" onclick="modificaNoticia(0)">

				</div>
			</div>
		</div>
	
	</div>

		
</body>
</html>