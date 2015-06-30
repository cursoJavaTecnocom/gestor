<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CONTENIDOS</title>
</head>
<body>

	<form action="grabaContenido.html" modelAttribute="contenido">
		<hidden path="id" />

		<label>descripcion:</label>
		<input type="text" path="descripcion"></textarea><br>


		<textarea rows="7" cols="120" path="contenido"></textarea><br>


		<button value="grabar" type="submit" name="grabar">Guardar</button>
	</form>

</body>
</html>