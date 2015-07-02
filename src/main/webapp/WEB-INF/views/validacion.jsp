<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/bootstrap.js" type="text/javascript"></script>
<title>Validacion</title>
</head>
<body>
	<header>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>Loggin
				</h1>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-4 col-md-4">
				<div class="well well-lg">
					<sp:form action="validacion.html?destino=${destino }" modelAttribute="usuario">
	
							<div class="form-group">
								<label>Usuario:</label>
								<sp:input path="usuario" cssClass="form-control" />
							</div>
							<div class="form-group">
								<label>Clave:  </label>
								<sp:input path="clave" cssClass="form-control" />
							</div>
		
		  
						<input type="submit" value="validar"  class="btn btn-default">
					</sp:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

