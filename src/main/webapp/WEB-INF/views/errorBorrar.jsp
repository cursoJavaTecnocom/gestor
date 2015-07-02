<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Error Page</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.1.4.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
</head>

<body>
	<%@include file="navegador.jsp"%>
	<header>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>D'oh!<small>
						page error</small>
				</h1>
			</div>
		</div>
	</header>


	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span><span> EL ZAMORANO NO DEJA BORRAR ESTE CONTENIDO!!!</span>
						<img src="http://stream1.gifsoup.com/view3/1158198/drinking-bird-o.gif" align="middle">
						
									
				</div>
			</div>
		</div>
	</div>
	<h3 align="center"><a href="contenidos.html?id=0"><input type="button" value=" Volver"
			class="btn btn-success" id="vueltas"></a></h3>		
</body>
</html>