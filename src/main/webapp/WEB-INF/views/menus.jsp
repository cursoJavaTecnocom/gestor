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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">GESTOR</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="usuarios.html">USUARIOS</a></li>
        <li><a href="menus.html">MENUS</a></li> 
        <li><a href="contenidos.html">CONTENIDOS</a></li> 
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
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
					<input type="button" class="btn btn-primary" value="Modificar" onclick="modificar(${menu.id},'modificaMenu.html')" />
					<input type="button" class="btn btn-warning" value="Borrar" onclick="borrar(${menu.id},'borraMenu.html')" />
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9"><input type="button" class="btn btn-success" value="Nuevo menú"  onclick="modificar(0,'modificaMenu.html')">
			</td>
		</tr>
	</table>
	</div>
</body>
</html>