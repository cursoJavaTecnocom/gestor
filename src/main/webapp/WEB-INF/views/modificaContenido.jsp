<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CONTENIDOS</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/contenido.js" type="text/javascript"></script>
</head>
<body>
<%@include file="navegador.jsp"%>  
	<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>Contenidos<small>JSP</small>
			</h1>
		</div>
	</div>
	</header>
	<div class="container">

		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<sp:form action="grabaContenido.html" modelAttribute="contenido">
					<div class="">
						<h3>
							<label class="label label-warning">Descripción:</label>
						</h3>
						<sp:input type="text" path="descripcion"></sp:input>

					</div>
					<sp:hidden path="id" />
					<h3>
						<label class="label label-danger">Contenido</label>
					</h3>
			</div>
		</div>
	</div>
	<div class="container">

		<div class="row">
			<div class="col-md-offset-45 col-md-45">
				<label for="editor1"></label>
				<sp:textarea cols="80" id="editor1" name="editor1" rows="10"
					path="contenido"></sp:textarea>
				<h3><br><input class="btn btn-success" type="submit" value="Grabar" id="vueltas"></h3>
				</sp:form>

				<ckeditor:replace replace="editor1" basePath="ckeditor/" />
			</div>
		</div>
	</div>
</body>
</html>