<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="js/jquery-2.1.4.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/contenido.js" type="text/javascript"></script>
</head>
<body>
	<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Contenidos<small>JSP</small>
			</h1>
		</div>
	</div>
	</header>

	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="well well-lg">
					<sp:form action="grabaContenido.html" modelAttribute="contenido">
						<sp:hidden path="id" />

						<div class="form-group">
							<label>descripcion:</label>
							<sp:input type="text" path="descripcion"></sp:input>
							<br>
						</div>

						<div class="form-group">
							<sp:textarea rows="7" cols="120" path="contenido"></sp:textarea>
							<br>
						</div>

						<button value="grabar" type="submit" value="Grabar" class="btn btn-default"></button>
					</sp:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>