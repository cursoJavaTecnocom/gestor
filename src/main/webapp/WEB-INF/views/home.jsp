<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="js/bootstrap.js" type="text/javascript"></script>
<title>Home</title>
<style>
#ulmenu {
	text-align: center;
}

#limenu a {
	font-size: 26px;
	text-align: center;
}
</style>
</head>
<body>
	<%@include file="navegador.jsp"%>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<ul id="ulmenu" class="list-group">
				<li id="limenu" class="list-group-item"><a
					href="contenidos.html">Contenidos</a></li>
				<li id="limenu" class="list-group-item"><a
					href="destacados.html">Destacados</a></li>
				<li id="limenu" class="list-group-item"><a href="menu.html">Menús</a></li>
				<li id="limenu" class="list-group-item"><a href="noticias.html">Noticias</a></li>
				<li id="limenu" class="list-group-item"><a
					href="principal.html">Principales</a></li>
				<li id="limenu" class="list-group-item"><a href="usuarios.html">Usuarios</a></li>
				<li id="limenu" class="list-group-item"><a href="imagenes.html">Imagenes</a></li>

			</ul>
		</div>
		<div class="col-md-3"></div>
	</div>

</body>
</html>
