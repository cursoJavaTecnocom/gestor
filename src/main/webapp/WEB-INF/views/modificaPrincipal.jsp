<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${principale.id == 0}">
	<h1>NUEVO PRINCIPAL</h1>
</c:if>
<c:if test="${principale.id != 0}">
	<h1>MODIFICAR PRINCIPAL</h1>
</c:if>


<sp:form action="grabaPrincipal.html" modelAttribute="principal"> 
		<sp:hidden path="id"/>
		<table>
			
			<tr>
				<td>Título</td>
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
</body>
</html>