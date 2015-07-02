<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/menu.js"></script>
</head>
<body>
<jsp:include page="navegador.jsp"></jsp:include>
<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<c:choose>
        <c:when test="${menu.titulo !=null}">
          <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>"${menu.titulo}"
        </c:when>
        <c:otherwise>
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo Menú
        </c:otherwise>
        </c:choose>
			</h1>
		</div>
	</div>
</header>
<div class="container">
	<sp:form action="grabaMenu.html" modelAttribute="menu" onsubmit="return validar();"> 
		<sp:hidden path="id"/>
		<table class="table table-striped">
			<tr>
				<td>Título</td> 
				<td>
					<sp:input path="titulo" required="true"/>
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
				<td>Link</td>
				<td>
					<sp:input path="link"/>
				</td>
			</tr>
			<tr>
				<td>Nivel</td>
				<td>
					<sp:input path="nivel" disabled="true"/>
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
				<td>Tipo menú</td>
				<td>
					<sp:select path="tipoMenu">
						<sp:option value="0">Selecciona un tipo de menu...</sp:option>
						<sp:option value="3">superior</sp:option>
					</sp:select>
				</td>
			</tr>
			<tr>
				<td>Menu padre</td>
				<td>
					<sp:select path="idMenuPadre" onchange="comprobarNivel();">
						<sp:option value="0" >Ninguno</sp:option>
						<c:forEach items="${menus}" var="menu">
							<c:choose>
								<c:when test="${menu.nivel==0}">
									<sp:option value="${menu.id}">${menu.titulo}</sp:option>
								</c:when>
							</c:choose>
						</c:forEach>						
					</sp:select>
				</td>
			</tr>
			<tr>
				<td colspan="9"><input type="submit" value="Grabar" /></td>
			</tr>
		</table>
	</sp:form>
	</div>
</body>
</html>