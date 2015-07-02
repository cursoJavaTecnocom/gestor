<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script src="js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
<%@include file="nav.jsp"%>
<%@include file="header.jsp" %>
<%@include file="Slider.jsp" %>
<div class="container">
<div class="row">
  <div class="col-sm-4">
  <div class="container">
  <h2>List Group With Custom Content</h2>
  <div class="list-group">
  <c:forEach items="${destacados}" var="destacado">
    <a href="verContenido.html?id=${destacado.contenido.id}" class="list-group-item active">
      <h4 class="list-group-item-heading">${destacado.titulo}</h4>
      <p class="list-group-item-text">${destacado.texto}</p>
    </a>
  </c:forEach>
    </div>
  </div>
  </div>
  <div class="col-sm-4">.col-sm-4</div>
  <div class="col-sm-4">.col-sm-4</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>