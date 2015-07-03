function comprobarNivel(){
	var nivel=document.forms[0].nivel;
	var padre=document.forms[0].idMenuPadre.value;
	
	if(padre!=0){
//		alert("Nivel=1");
		nivel.value=1;
	}
	
	if(padre==0){
//		alert("Nivel=0");
		nivel.value=0;
	}
}

function validar(){
		var nivel=document.forms[0].nivel.value;
		var contenido=document.forms[0].contenido.value;
		var idMenuPadre=document.forms[0].idMenuPadre.value;
		var tipoMenu=document.forms[0].tipoMenu.value;
		var tiposMenus=document.forms[0].tipoMenu;
		var tipoMenuText=tiposMenus.options[tiposMenus.selectedIndex].text;
		
		
		
		if(tipoMenu==0 || !(tipoMenuText=='superior')){
			alert("Tipo de menu no valido");
			return false;
		}
		
		if((nivel>0 && idMenuPadre==0)){
			alert("Debe seleccionar un menu padre");
			return false;
		}
		
		if(contenido==0){
			alert("Debe seleccionar un contenido");
			return false;
		}
}



