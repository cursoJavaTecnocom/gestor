<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/usuariosjs.js"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${usuarios.id != 0}">
		<header>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Modificar
					"${usuario.usuario}"
				</h1>
			</div>
		</div>
		</header>
	</c:if>
	<c:if test="${usuarios.id == 0}">
		<header>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Nuevo
					Usuario
				</h1>
			</div>
		</div>
		</header>
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="well well-lg">
					<sp:form action="grabaUsuario.html" modelAttribute="usuario">
						<sp:hidden path="id" />
						<table id="miTabla" class="table table-striped">
							<tr>
								<td>Usuario</td>
								<td><sp:input path="usuario" /></td>
							</tr>
							<tr>
								<td>Contraseña</td>
								<td><sp:input path="clave" /></td>
							</tr>
						</table>
						<tr>
							<td><input type="submit" value="grabar" class="btn btn-primary"></td>
						</tr>
					</sp:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html> 