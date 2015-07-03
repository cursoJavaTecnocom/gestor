/**
 * 
 */
function borraUsuario(id)
{
document.location="borraUsuario.html?id="+id;	
}
function modificaUsuario(id)
{
document.location="modificaUsuario.html?id="+id	
}

function validateForm() {
    var x = document.forms["miFormulario"]["usuario"].value;
    var y = document.forms["miFormulario"]["clave"].value;
    if (x == null || x == "" || y == null || y == "") 
    {
       if(   y == null || y == "" ) {
    	   alert("La clave no puede estar vacia");
    	   document.getElementById("cla").style.background = "#FF6C47";
    	   document.getElementById("cla").focus();
    	   
       }
       else {
    	   alert("El usuario no puede estar vacio");
    	   document.getElementById("usu").style.background = "#FF6C47";
    	   document.getElementById("usu").focus();
       }
   
       
        return false;
    }
}