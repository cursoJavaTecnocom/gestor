<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery.js"></script>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script src="js/bootstrap.js" type="text/javascript"></script>

<script type="text/javascript">

function borraPrincipal(id,cantidad)
{
	if(cantidad>0){
		alert("Existen datos asociados");
		return;
	}
document.location="borraPrincipal.html?id="+id;
}

function modificaPrincipal(id)
{
 document.location="modificaPrincipal.html?id="+id;	
}

</script>




<link rel="stylesheet" href="css/bootstrap.css">

</head>
<body>
<%@include file="navegador.jsp"%>
<header>
		<div class="jumbotron">
			<div class="container"><h1><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>Contenidos<small>JSP</small></h1></div>
		</div>
</header>

<div class="container">

		<div class="row">
			<div class="col-md-offset-30 col-md-30">


<table border="2" class="table table-striped">

	<tr>
		<td>ID</td>
		<td>TITULO</td>
		<td>TEXTO</td>
		<td>IMAGEN</td>
		<td>CONTENIDO</td>
		<td>ACCIONES</td>
	</tr>
	
 	<c:forEach items="${principales}" var="principale">
	
	<tr>
		<td>${principale.id}</td>
		<td>${principale.titulo}</td>
		<td>${principale.texto}</td>
		<td>${principale.imagene.id}</td>
		<td>${principale.contenido.descripcion}</td>
		<td>
			<input type="button" value="Modificar" class="btn btn-primary" onclick="modificaPrincipal(${principale.id},'modificaPrincipal.html')" >			
			<input type="button" value="Borrar" class="btn btn-warning" onclick="borraPrincipal(${principale.id})">
		</td>
	</tr>
	



	</c:forEach>     
</table>
<a href="modificaPrincipal.html?id=0"><input type="button" value=" Añadir nuevo principal" class="btn btn-success"></a>
</div>
		</div>
	</div>



</body>
</html>