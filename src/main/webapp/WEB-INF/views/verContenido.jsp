<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header> <jsp:include page="header.jsp" /> </header>
	<%@include file="nav.jsp"%>
	<jsp:include page="slider.jsp" />

	<div>${contenido.contenido }</div>
	<h3 align="center">
		<a href=".html?id=0"><input type="button" value=" Volver"
			class="btn btn-success" id="vueltas"></a>
	</h3>
	<footer> <jsp:include page="footer.jsp" /> </footer>

</body>
</html>