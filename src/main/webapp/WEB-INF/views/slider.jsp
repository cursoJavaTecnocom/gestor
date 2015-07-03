<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 1000px; margin: 0 auto">
  <!-- Indicators -->
  <ol class="carousel-indicators">
  <c:set value="0"  var="posicion"></c:set>
  <c:forEach items="${imagenesCarrusel }" var="imagen">
  <c:if test="${posicion==0}">
    <li data-target="#myCarousel" data-slide-to="${posicion }" class="active"></li>
    <c:set   var="posicion" value="${posicion+1 }"></c:set>
    </c:if>
    <c:if test="${posicion>0}">
    <li data-target="#myCarousel" data-slide-to="${posicion }" ></li>
    <c:set   var="posicion" value="${posicion+1 }"></c:set>
    </c:if>
    </c:forEach>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <c:set value="0"  var="posicion"></c:set>
    <c:forEach items="${imagenesCarrusel }" var="imagen">
    <c:if test="${posicion==0}">
    <div class="item active">
      <img  src="images/${imagen.nombre }">
      <c:set   var="posicion" value="${posicion+1 }"></c:set>
    </div>
    </c:if>
    <c:if test="${posicion>0}">
    <div class="item">
      <img  src="images/${imagen.nombre }">
    </div>
    </c:if>
    </c:forEach>
  </div>
  
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>