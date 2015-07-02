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
<% int hijos=0; %>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.html">GESTOR</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
     <c:forEach items="${menus}" var="menu">
							<c:choose>
								<c:when test="${menu.nivel==0}">
<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="verContenido.html?id=${menu.contenido.id}">${menu.titulo}<span class="caret"></span></a>
							          <ul class="dropdown-menu">
								<c:forEach items="${menus}" var="menuHijo">
								<c:choose>
								<c:when test="${menu.id== menuHijo.idMenuPadre}">							
							       <li><a href="verContenido.html?id=${menu.contenido.id}">${menu.titulo}</a></li>
								</c:when>
								</c:choose>
								</c:forEach>
								</ul>
 </li>
								</c:when>
							</c:choose>
		</c:forEach>		
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="validacion.html"><span class="glyphicon glyphicon-user"></span>Login</a></li>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>