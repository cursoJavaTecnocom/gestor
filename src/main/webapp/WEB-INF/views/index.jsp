<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Javanianos</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script src="js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
<header>
${header.contenido }
<%@include file="nav.jsp"%>
</header>

<%@include file="slider.jsp" %>

<div class="row">
<div class="col-md-2"><%@include file="bannerizquierdo.jsp" %></div>
<div class="col-md-1"></div>
  <div class="col-md-2">
  <h2>Destacados</h2>
  <div class="list-group">
  <c:forEach items="${destacados}" var="destacado">
    <a href="verContenido.html?id=${destacado.contenido.id}" class="list-group-item active">
      <h4 class="list-group-item-heading">${destacado.titulo}</h4>
      <p class="list-group-item-text">${destacado.texto}</p>
    </a>
  </c:forEach>
    </div>
  </div>
  <div class="col-md-2"><h2>Noticias</h2>
  <div class="list-group">
  <c:forEach items="${noticias}" var="noticia">
    <a href="verContenido.html?id=${noticia.contenido.id}" class="list-group-item active">
      <h4 class="list-group-item-heading">${noticia.titulo}</h4>
      <p class="list-group-item-text">${noticia.texto}</p>
    </a>
  </c:forEach>
    </div></div>
  <div class="col-md-2"><h2>Principales</h2>
  <div class="list-group">
  <c:forEach items="${principales}" var="principal">
    <a href="verContenido.html?id=${principal.contenido.id}" class="list-group-item active">
      <h4 class="list-group-item-heading">${principal.titulo}</h4>
      <p class="list-group-item-text">${principal.texto}</p>
    </a>
  </c:forEach>
    </div></div>
    <div class="col-md-3"><%@include file="bannerderecho.jsp" %></div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
