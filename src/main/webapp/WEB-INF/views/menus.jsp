<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
<title>Insert title here</title>
<script type="text/javascript">
//Funcion modificar estándar
	function modificar(id,destino){
		document.location=destino+"?id="+id;
	}
	
	function borrar(id,destino){
		document.location=destino+"?id="+id;
	}
</script>
</head>
<body>
<%@include file="navegador.jsp"%>
<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<span class="glyphicon glyphicon-cutlery" aria-hidden="true"></span>Menús
			</h1>
		</div>
	</div>
	</header>

<div class="container">
	<table id="menu" class="table table-striped" >
	<tr>
		<th>ID</th>
		<th>TIPO MENÚ</th>
		<th>TÍTULO</th>
		<th>LINK</th>
		<th>NIVEL</th>
		<th>CONTENIDO</th>
		<th>IMAGEN</th>
		<th>MENÚ PADRE</th>
		<th>ACCIONES</th>
		</tr>
		<c:forEach items="${menus}" var="menu">
			<tr>
				<td>${menu.id}</td>
				<td>${menu.tipoMenu.descripcion}</td>
				<td>${menu.titulo}</td>
				<td>${menu.link}</td>
				<td>${menu.nivel}</td>
				<td>${menu.contenido.descripcion}</td>
				<td>${menu.imagene.nombre}</td>
				<td>${menu.idMenuPadre} </td>
				<td>
					<button class="btn btn-primary" onclick="modificar(${menu.id},'modificaMenu.html')" ><span class="glyphicon glyphicon-pencil"> Modificar</span></button>
					<button class="btn btn-warning" onclick="borrar(${menu.id},'borraMenu.html')"><span class="glyphicon glyphicon-trash"> Borrar</span></button>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9"><button class="btn btn-success"  onclick="modificar(0,'modificaMenu.html')"><span class="glyphicon glyphicon-plus-sign" style="font-size:1.3em;vertical-align:middle">Nuevo</span></button>
			</td>
		</tr>
	</table>
	</div>
</body>
</html>