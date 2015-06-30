<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery-2.1.4.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
<title>Insert title here</title>
<script type="text/javascript">
//Funcion modificar est�ndar
	function modificar(id,destino){
		document.location=destino+"?id="+id;
	}
	
	function borrar(id,destino){
		document.location=destino+"?id="+id;
	}
</script>
</head>
<body>
<header class="navbar navbar-header">
<div class="container">
  <div class="navbar-nav">
      <a class="brand" href="#">Gestor</a>
      <ul class="nav">
        <li class="active"><a href="#">Menus</a></li>
        <li><a href="#about">Usuarios</a></li>
        <li><a href="#contact">Contenido</a></li>
      </ul>
  </div>
  </div>
</header>
<div class="container">
	<table id="menu" class="table table-striped" >
	<tr>
		<th>ID</th>
		<th>TIPO MEN�</th>
		<th>T�TULO</th>
		<th>LINK</th>
		<th>NIVEL</th>
		<th>CONTENIDO</th>
		<th>IMAGEN</th>
		<th>MEN� PADRE</th>
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
					<input type="button" class="btn btn-primary" value="Modificar" onclick="modificar(${menu.id},'modificaMenu.html')" />
					<input type="button" class="btn btn-warning" value="Borrar" onclick="borrar(${menu.id},'borraMenu.html')" />
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
				<input type="button" class="btn btn-success" value="Nuevo men�"  onclick="modificar(0,'modificaMenu.html')">
			</td>
		</tr>
	</table>
	</div>
</body>
</html>