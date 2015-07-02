<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home.html">GESTOR</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="usuarios.html">USUARIOS</a></li>
        <li><a href="menu.html">MENUS</a></li> 
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="contenidos.html">Contenidos<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="destacados.html">Destacados</a></li>
            <li><a href="noticias.html">Noticias</a></li>
            <li><a href="principal.html">Principales</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span><%=session.getAttribute("usuLogado") %></a></li>
        <li><a href="cerrarSesion.html"><span class="glyphicon glyphicon-off"></span> Cerrar Sesión</a></li>
      </ul>
    </div>
  </div>
</nav>