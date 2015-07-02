function borraContenido(id)
{	
	if(confirm("¿Estas segurro de borrar el contenido?"))
	{
		document.location="borraContenido.html?id="+id;
	}	
}

function modificaContenido(id)
{
	document.location="modificaContenido.html?id="+id;
}

function verContenido(id)
{
	document.location="verContenido.html?id="+id;
}
function contenidos(id)
{
	document.location="contenidos.html?.id=" + id;
}
