<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>

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

<script type="text/javascript">
		$(document).ready(function(){
			
			var opciones = document.forms[0].idcontenido;
			for (i = 0; i < opciones.length; i++) {
				if(opciones[i].value == ${noticia.contenido.id})
					opciones[i].selected=true;
			}
		});
</script>

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

		<c:if test="${noticia.id gt 0}"><h1>Modifica esta noticia</h1></c:if>
		<c:if test="${empty noticia.id}"><h1>Añade una nueva noticia</h1></c:if>
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="well well-lg">
					<sp:form action="grabaNoticia.html" modelAttribute="noticia">
						<input type="hidden" name="id" value="${noticia.id }">
						<div class="form-group">
							<label for="idfecha">Fecha</label> 
							<sp:input path="fecha" cssClass="form-control" />
						</div>
						
						<div class="form-group">
							<label for="idtitulo">Titulo</label> 
							<sp:input path="titulo" cssClass="form-control" />
						</div>
						
						<div class="form-group">
							<label for="idtexto">Texto</label> 
							<sp:input path="texto" cssClass="form-control" />
						</div>
						
						<div class="form-group">
							<label for="idcontenido">Contenido</label>
							<sp:select path="contenido" cssClass="form-control" id="idContenido">
								<sp:option value="0">Selecciona contenido ...</sp:option>
								<sp:options items="${contenidos }" itemLabel="contenido" itemValue="id" />
							</sp:select>
						</div>
							
						<input type="submit" value="Grabar" class="btn btn-default">
					</sp:form>
				</div>
			</div>
		</div>

	</div>
	
</body>
</html>