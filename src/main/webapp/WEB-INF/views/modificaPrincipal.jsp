<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body>
<%@include file="navegador.jsp"%>
	<header>
		<div class="jumbotron">
			<div class="container">
				
					<c:if test="${principale.id == 0}">
						<h1><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Nuevo principal</h1>
					</c:if>
					<c:if test="${principale.id != 0}">
						<h1><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Modificación de principal</h1>
					</c:if>
				
			</div>
		</div>
	</header>


<div class="container">
<sp:form action="grabaPrincipal.html" modelAttribute="principal"> 
		<sp:hidden path="id"/>
		<table class="table table-striped">
			
			<tr> 
				<td><b>Título</b></td>
				<td>
					<sp:input path="titulo"/>
				</td>
			</tr>
			
			<tr>
				<td ><b>Texto</b></td>
				<td>
					<sp:input path="texto"/>
				</td>
			</tr>
			
			<tr>
				<td><b>Imagen</b></td>
				<td>
					<sp:select path="imagene">
						<sp:option value="0">Selecciona una imagen...</sp:option>
						<sp:options items="${imagenes}" itemLabel="nombre" itemValue="id"/>
					</sp:select>
				</td>
			</tr>
			
			<tr>
				<td><b>Contenido</b></td>
				<td>
					<sp:select path="contenido">
						<sp:option value="0">Selecciona un contenido...</sp:option>
						<sp:options items="${contenidos}" itemLabel="descripcion" itemValue="id"/>
					</sp:select>
				</td>
			</tr>
			

		</table>
		<h3><br><input class="btn btn-success" type="submit" value="Grabar" id="vueltas"></h3>
	</sp:form>
	</div>
</body>
</html>