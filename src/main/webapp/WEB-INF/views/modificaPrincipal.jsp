<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="js/bootstrap.js" type="text/javascript"></script>

</head>
<body>
<%@include file="navegador.jsp"%>
	<header>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<c:if test="${principale.id eq 0}">
						<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span> Nuevo Destacado
					</c:if>
					<c:if test="${principale.id gt 0}">
						<span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> Modificaci�n de Destacado
					</c:if>
				</h1>
			</div>
		</div>
	</header>


<div class="container">
<sp:form action="grabaPrincipal.html" modelAttribute="principal"> 
		<sp:hidden path="id"/>
		<table>
			
			<tr>
				<td>T�tulo</td>
				<td>
					<sp:input path="titulo"/>
				</td>
			</tr>
			
			<tr>
				<td>Texto</td>
				<td>
					<sp:input path="texto"/>
				</td>
			</tr>
			
			<tr>
				<td>Imagen</td>
				<td>
					<sp:select path="imagene">
						<sp:option value="0">Selecciona una imagen...</sp:option>
						<sp:options items="${imagenes}" itemLabel="nombre" itemValue="id"/>
					</sp:select>
				</td>
			</tr>
			
			<tr>
				<td>Contenido</td>
				<td>
					<sp:select path="contenido">
						<sp:option value="0">Selecciona un contenido...</sp:option>
						<sp:options items="${contenidos}" itemLabel="descripcion" itemValue="id"/>
					</sp:select>
				</td>
			</tr>
			
			<tr>
				<td colspan="4"><input type="submit" value="Grabar"/></td>
			</tr>
		</table>
	</sp:form>
	</div>
</body>
</html>