<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CONTENIDOS</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/contenido.js" type="text/javascript"></script>
</head>
<body>
	<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>Contenidos<small>JSP</small>
			</h1>
		</div>
	</div>
	</header>

	
					<sp:form action="grabaContenido.html" modelAttribute="contenido">
					
							<label>DESCRIPCION:</label>
							<sp:input type="text" path="descripcion"></sp:input>
						
						<sp:hidden path="id" />

						

						
							<label for="editor1">Editor 1:</label>
							<sp:textarea cols="80" id="editor1" name="editor1" rows="10" path="contenido"></sp:textarea>
						

						<input type="submit" value="Grabar">
					</sp:form>
	
	<ckeditor:replace replace="editor1" basePath="ckeditor/"/>
</body>
</html>