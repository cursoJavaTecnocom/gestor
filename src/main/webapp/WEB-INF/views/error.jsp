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
						aria-hidden="true"></span><span> An error has occurred in
						Zamora</span>
						<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span><span> NO SE PUEDE BORRAR</span>
					
				</div>
			</div>
		</div>
	</div>



</body>
</html>