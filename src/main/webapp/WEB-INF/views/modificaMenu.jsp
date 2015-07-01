<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validar(){
		var nivel=document.forms[0].nivel.value;
		var idMenuPadre=document.forms[0].idMenuPadre.value;
		var tipoMenu=document.forms[0].tipoMenu.value;
		if(nivel>0 && idMenuPadre==0)
			alert("Debe seleccionar un menú padre");
		if(tipoMenu==0)
			alert("Debe seleccionar un tipo de menú");
		else
			document.forms[0].submit();
	}
</script>
</head>
<body>
	<sp:form action="grabaMenu.html" modelAttribute="menu"> 
		<sp:hidden path="id"/>
		<table>
			<tr>
				<td>Título</td>
				<td>
					<sp:input path="titulo"/>
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
					<sp:input  path="nivel" disabled="true"/>
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
						<sp:options items="${tiposMenus}" itemLabel="descripcion" itemValue="id"/>
					</sp:select>
				</td>
			</tr>
			<tr>
				<td>Menu padre</td>
				<td>
					<sp:select path="idMenuPadre">
						<sp:option value="0">Selecciona un menu padre...</sp:option>
						<sp:options items="${menus}" itemLabel="titulo" itemValue="id"/>
					</sp:select>
				</td>
			</tr>
			<tr>
				<td colspan="9"><input type="button" value="Grabar" onclick="validar()"/></td>
			</tr>
		</table>
	</sp:form>
</body>
</html>