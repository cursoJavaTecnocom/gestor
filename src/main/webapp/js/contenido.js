function borraContenido(id,contenido)
{	
	if (contenido > 0){
		alert("NO SE PUEDE BORRAR");
		return;
	}
	document.location="borraContenido.html?id="+id;
}

function modificaContenido(id)
{
	document.location="modificaContenido.html?id="+id;
}

function verContenido(id)
{
	document.location="verContenido.html?id="+id;
}
