<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<table border="1">
		<th>ID</th>
		<th>TIPO MENÚ</th>
		<th>TÍTULO</th>
		<th>LINK</th>
		<th>NIVEL</th>
		<th>CONTENIDO</th>
		<th>IMAGEN</th>
		<th>MENÚ PADRE</th>
		<th>ACCIONES</th>
		
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
					<input type="button" value="Modificar" onclick="modificar(${menu.id},'modificaMenu.html')" />
					<input type="button" value="Borrar" onclick="borrar(${menu.id},'borraMenu.html')" />
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
				<input type="button" value="Nuevo menú"  onclick="modificar(0,'modificaMenu.html')">
			</td>
		</tr>
	</table>
</body>
</html>