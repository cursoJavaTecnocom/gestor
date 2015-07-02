<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<%=request.getContextPath()%>">GESTOR</a>
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
							       <li><a href="verContenido.html?id=${menuHijo.contenido.id}">${menuHijo.titulo}</a></li>
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
        <li><a href="home.html"><span class="glyphicon glyphicon-user"></span>Admin</a></li>
      </ul>
    </div>
  </div>
</nav>