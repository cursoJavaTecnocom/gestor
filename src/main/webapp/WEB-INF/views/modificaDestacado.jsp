<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
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

<sp:form action="grabaDestacado.html" modelAttribute="destacado">
	<sp:hidden path="id"/>
 <table border="1">

  <tr>
	<td>TÍTULO</td>
	<td><sp:input path="titulo"/></td>
  </tr>
  <tr>
	<td>TEXTO</td>
	<td><sp:input path="texto"/></td>
  </tr>
		<tr>
			<td>CONTENIDO</td>
			<td>
				<sp:select path="contenido" id="selectContenido">
					<sp:option value="0">Selecciona Contenido...</sp:option>
					<sp:options items="${contenidos }" itemLabel="descripcion" itemValue="id"/>
				</sp:select>
			</td>
		</tr>
  <tr>
	<td colspan="2"><input type="submit" value="Grabar"></td>
  </tr>

 </table>
 <!-- <input type="submit" value="Grabar"> -->


</sp:form>

</body>
</html>