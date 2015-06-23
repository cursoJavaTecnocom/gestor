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

	<sp:form action="grabaContenido.html" modelAttribute="contenido">
		<sp:hidden path="id" />
		
			<label>Descripción:</label>
			 <sp:textarea path="descripcion"/>
		
		
			<sp:textarea path="contenido" /></td>
		
		<td colspan="2"></td>
		<sp:button value="grabar" type="submit" name="grabar">Guardar</sp:button>
	</sp:form>

</body>
</html>