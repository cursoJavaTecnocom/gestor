<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/bootstrap.js" type="text/javascript"></script>
<title>Validacion</title>
</head>
<body>
	<header>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Loggin
				</h1>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<sp:form action="validacion.html" modelAttribute="usuario">
				<table border="1" id="miTabla" class="table table-striped">
					<tr>
						<td>Usuario:</td>
						<td><sp:input path="usuario" /></td>
					</tr>
					<tr>
						<td>Clave</td>
						<td><sp:input path="clave" /></td>
					</tr>


				</table>
				<input type="submit" value="validar">
			</sp:form>
		</div>
	</div>
</body>
</html>

