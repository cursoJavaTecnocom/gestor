<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Noticias</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.1.4.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/jsnoticias.js" type="text/javascript"></script>
</head>
<body>

	<header>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Noticias<small>JSP</small>
				</h1>
			</div>
		</div>
	</header>

	<div class="container">

		<c:if test="${cargo.id gt 0}"><h1>Modifica esta noticia</h1></c:if>
		<c:if test="${empty cargo.id}"><h1>Añade nueva noticia</h1></c:if>
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="well well-lg">
					<form action="grabaNoticia">
						<input type="hidden" name="id" value="${noticia.id }">
						<div class="form-group">
							<label for="idfecha">Fecha</label> 
							<input type="text" name="fecha" class="form-control" id="idfecha" placeholder="${cargo.descripcion}" value="">
						</div>
						
						<div class="form-group">
							<label for="idtitulo">Titulo</label> 
							<input type="text" name="fecha" class="form-control" id="idtitulo" placeholder="${cargo.descripcion}" value="">
						</div>
						
						<div class="form-group">
							<label for="idtexto">Titulo</label> 
							<input type="text" name="fecha" class="form-control" id="idtexto" placeholder="${cargo.descripcion}" value="">
						</div>
						
						<div class="form-group">
							<label for="idcontenido">Contenido</label> 
							<input type="text" name="fecha" class="form-control" id="idcontenido" placeholder="${cargo.descripcion}" value="">
						</div>
						
						<input type="submit" value="Grabar" class="btn btn-default">
					</form>
				</div>
			</div>
		</div>

	</div>

	</div>

	<%@include file="footer.jsp"%>
</body>
</html>