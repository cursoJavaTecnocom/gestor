<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="mc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CONTENIDOS</title>
</head>
<body>

	<mc:form action="grabaContenido.html" modelAttribute="contenido">
		<mc:hidden path="id" />
		<tr>
			<td>Descripción</td>
			<td align="justify"><mc:textarea path="descripcion" /></td>
		</tr>
		<tr>
			<td align="justify" height="200px" width="100px"><mc:textarea
					path="contenido" /></td>
		</tr>
		<td colspan="2"></td>
		<mc:button value="grabar" type="submit" name="grabar">Guardar</mc:button>
	</mc:form>

</body>
</html>