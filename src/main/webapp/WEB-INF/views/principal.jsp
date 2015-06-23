<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery.js"></script>

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

<table border="2" id="miTabla" class="table table-hover">

	<tr>
		<td>ID</td>
		<td>TITULO</td>
		<td>TEXTO</td>
		<td>IMAGEN</td>
		<td>CONTENIDO</td>
	</tr>
	
 	<c:forEach items="${principales}" var="principal">
	
	<tr>
		<td>${principale.id}</td>
		<td>${principale.titulo}</td>
		<td>${principale.texto}</td>
		<td>${principale.imagene.id}</td>
		<td>${principale.contenido.descripcion}</td>
		<td>
			<input type="button" value="Modificar" >			
			<input type="button" value="Borrar" >
		</td>
	</tr>
	
	<tr>
	<td></td>
	</tr>


	</c:forEach>     
</table>
<a href="modificaPrincipal.html?id=0">Nuevo Principal</a>



</body>
</html>