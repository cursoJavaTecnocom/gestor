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
	  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 300px;
      heigth: 200px;
      margin: auto;
  }
  .carousel-inner>.item>a>img, .carousel-inner>.item>img, .img-responsive, .thumbnail a>img, .thumbnail>img {
  display: block;
  max-width: 100%;
  height: 400px;
  width: 600px;
}
footer{
background-color: black;
}
  </style>
</head>
<body>
<header>
<c:forEach items="${contenidoHeader }" var="header">

<p class="text-muted credit">${header.contenido }</p>

</c:forEach>
<%@include file="nav.jsp"%>
</header>

<%@include file="slider.jsp"%>

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
<footer>

  <div id="footer">

      <div class="container">
        <c:forEach items="${contenidoFooter }" var="footer">
       ${footer.contenido }
          </c:forEach>
      </div>
    
    </div>

</footer>
</body>
</html>
