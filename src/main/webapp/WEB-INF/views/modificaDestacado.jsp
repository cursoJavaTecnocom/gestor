<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestiona Destacados</title>
</head>
<body>

<c:if test="${empty destacado.id}">
	<h1>ALTA DE DESTACADOS</h1>
</c:if>
<c:if test="${destacado.id gt 0}">
	<h1>MODIFICACIÓN DE DESTACADOS</h1>
</c:if>

<form action="grabaDestacado.html">
<input type="hidden" name="id" value="${destacado.id}">
 <table border="1">

  <tr>
	<td>TÍTULO</td>
	<td><input type="text" name="titulo" value="${destacado.titulo}"></td>
  </tr>
  <tr>
	<td>TEXTO</td>
	<td><input type="text" name="texto" value="${destacado.texto}"></td>
  </tr>
  <tr>
	<td colspan="2"><input type="submit" value="Grabar"></td>
  </tr>

 </table>
 <!-- <input type="submit" value="Grabar"> -->


</form>

</body>
</html>