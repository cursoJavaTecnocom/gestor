<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>
	<%@include file="navegador.jsp"%>
	<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Principales<small>JSP</small>
			</h1>
		</div>
	</div>
	</header>

	<div class="container">
		<c:if test="${principale.id == 0}">			<h1>NUEVO PRINCIPAL</h1>		</c:if>
		<c:if test="${principale.id != 0}">			<h1>MODIFICAR PRINCIPAL</h1>		</c:if>
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="well well-lg">
					<sp:form action="grabaPrincipal.html" modelAttribute="principal">
						<sp:hidden path="id" />
							<div class="form-group">
								<label>Título</label>
								<sp:input path="titulo" cssClass="form-control" />
							</div>

							<div class="form-group">
								<label>Texto</label>
								<sp:input path="texto" cssClass="form-control" />
							</div>

							<div class="form-group">
								<label>Imagen</label>
								<sp:select path="imagene" cssClass="form-control">
										<sp:option value="0">Selecciona una imagen...</sp:option>
										<sp:options items="${imagenes}" itemLabel="nombre" itemValue="id" />
									</sp:select>
							</div>

							<div class="form-group">
								<label>Contenido</label>
								<sp:select path="contenido" cssClass="form-control">
										<sp:option value="0">Selecciona un contenido...</sp:option>
										<sp:options items="${contenidos}" itemLabel="descripcion" itemValue="id" />
									</sp:select>
							</div>

							<input type="submit" value="Grabar" class="btn btn-default">
					</sp:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>