<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>

<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 800px; margin: 0 auto">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="http://i.emezeta.com/weblog/meme-la-cosa/cosa-no-pinta-nada-bien.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="http://i.emezeta.com/weblog/meme-la-cosa/cosa-bajo-control.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="http://i.emezeta.com/weblog/meme-la-cosa/cada-cosa-en-su-momento.jpg" alt="Flower">
    </div>

    <div class="item">
      <img src="http://26.media.tumblr.com/tumblr_lvdhn1YfwQ1qc8755o1_r1_500.jpg" alt="Flower">
    </div>
    
    <div class="item">
      <img src=" http://i.emezeta.com/weblog/meme-la-cosa/cosa-bollos.jpg" alt="Flower">
    </div>
    
    <div class="item">
      <img src="http://i.emezeta.com/weblog/meme-la-cosa/cosa-container.jpg" alt="Flower">
    </div>
    
  </div>
  
 

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</body>
</html>