<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<th>ID</th>
		<th>TIPO MEN�</th>
		<th>T�TULO</th>
		<th>LINK</th>
		<th>NIVEL</th>
		<th>CONTENIDO</th>
		<th>IMAGEN</th>
		<th>MEN� PADRE</th>
		<th>ACCIONES</th>
		
		<c:forEach items="${menus}" var="menu">
			<tr>
				<td>${menu.}</td>
				<td>${menu.}</td>
				<td>${menu.}</td>
				<td>${menu.}</td>
				<td>${menu.}</td>
				<td>${menu.}</td>
				<td>${menu.}</td>
				<td>${menu.} </td>
				<td>${menu.}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>
				<input type="button" value="Nuevo men�" >
			</td>
		</tr>
	</table>
</body>
</html>