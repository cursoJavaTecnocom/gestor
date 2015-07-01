<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript">
	function validar(){
		var nivel=document.forms[0].nivel.value;
		var idMenuPadre=document.forms[0].idMenuPadre.value;
		var tipoMenu=document.forms[0].tipoMenu.value;
		var tiposMenus=document.forms[0].tipoMenu;
		var tipoMenuText=tiposMenus.options[tiposMenus.selectedIndex].text;
		
		if(tipoMenu==0 || !(tipoMenuText=='superior'))
			alert("Tipo de menú no válido");
		
		if((nivel>0 && idMenuPadre==0))
			alert("Debe seleccionar un menú padre");
		
		else
			document.forms[0].submit();
	}
</script>
</head>
<body>
<jsp:include page="navegador.jsp"></jsp:include>
<header>
	<div class="jumbotron">
		<div class="container">
			<h1>
				<c:choose>
        <c:when test="${menu.titulo !=null}">
          <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>"${menu.titulo}"
        </c:when>
        <c:otherwise>
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo Menú
        </c:otherwise>
        </c:choose>
			</h1>
		</div>
	</div>
</header>
<div class="container">
	<sp:form action="grabaMenu.html" modelAttribute="menu"> 
		<sp:hidden path="id"/>
		<table class="table table-striped">
			<tr>
				<td>Título</td>
				<td>
					<sp:input path="titulo"/>
				</td>
			</tr>
			<tr>
				<td>Contenido</td>
				<td>
					<sp:select path="contenido">
						<sp:option value="0">Selecciona un contenido...</sp:option>
						<sp:options items="${contenidos}" itemLabel="descripcion" itemValue="id"/>
					</sp:select>
				</td>
			</tr>
			<tr>
				<td>Link</td>
				<td>
					<sp:input path="link"/>
				</td>
			</tr>
			<tr>
				<td>Nivel</td>
				<td>
					<sp:input  path="nivel"/>
				</td>
			</tr>
			<tr>
				<td>Imagen</td>
				<td>
					<sp:select path="imagene">
						<sp:option value="0">Selecciona una imagen...</sp:option>
						<sp:options items="${imagenes}" itemLabel="nombre" itemValue="id"/>
					</sp:select>
				</td>
			</tr>
			<tr>
				<td>Tipo menú</td>
				<td>
					<sp:select path="tipoMenu">
						<sp:option value="0">Selecciona un tipo de menu...</sp:option>
						<sp:option value="3">superior</sp:option>
					</sp:select>
				</td>
			</tr>
			<tr>
				<td>Menu padre</td>
				<td>
					<sp:select path="idMenuPadre">
						<sp:option value="0" >Ninguno</sp:option>
						<c:forEach items="${menus}" var="menu">
							<c:choose>
								<c:when test="${menu.nivel==0}">
									<sp:option value="${menu.id}">${menu.titulo}</sp:option>
								</c:when>
							</c:choose>
						</c:forEach>						
					</sp:select>
				</td>
			</tr>
			<tr>
				<td colspan="9"><input type="button" value="Grabar" onclick="validar()"/></td>
			</tr>
		</table>
	</sp:form>
	</div>
</body>
</html>