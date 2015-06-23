<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Noticias</title>
	
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery-2.1.4.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="js/jsnoticias.js" type="text/javascript"></script>
</head>
<body>

	<header>
		<div class="jumbotron">
			<div class="container"><h1><span class="glyphicon glyphicon-fire" aria-hidden="true"></span>INDEX<small>JSP</small></h1></div>
		</div>
	</header>
	
	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="well well-lg">
					
					  <input type="button" value="ir a Noticias" class="btn btn-warning" onclick="noticias()">
					 					  
				</div>
			</div>
		</div>
	
	</div>

		<%@include file="footer.jsp" %>
</body>
</html>