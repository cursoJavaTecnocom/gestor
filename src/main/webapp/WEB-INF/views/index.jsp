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
  <c:forEach items="${destacados}"></c:forEach>
  </div>
  <div class="col-sm-4">.col-sm-4</div>
  <div class="col-sm-4">.col-sm-4</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>