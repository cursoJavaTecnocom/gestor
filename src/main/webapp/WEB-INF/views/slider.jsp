<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
  </style>
</head>
<body>

<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 1000px; margin: 0 auto">
  <!-- Indicators -->
  <ol class="carousel-indicators">
  <c:set value="0"  var="posicion"></c:set>
  <c:forEach items="${imagenesCarrusel }" var="imagen">
    <li data-target="#myCarousel" data-slide-to="${posicion }" ></li>
    <c:set   var="posicion" value="${posicion+1 }"></c:set>
    </c:forEach>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    
    <c:forEach items="${imagenesCarrusel }" var="imagen">
    <div class="item">
      <img  src="images/${imagen.nombre }">
    </div>
    </c:forEach>
  </div>
  
 

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</body>
</html>