/**
 * 
 */

function noticias() {
	document.location = "noticias.html";
}

function modificaNoticia(id) {
	document.location = "modificaNoticia.html" + "?id=" + id;
}

function borraNoticia(id){
	document.location = "borraNoticia.html" + "?id=" + id;
}