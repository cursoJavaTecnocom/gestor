
function validar(){
		var nivel=document.forms[0].nivel.value;
		var contenido=document.forms[0].contenido.value;
		var idMenuPadre=document.forms[0].idMenuPadre.value;
		var tipoMenu=document.forms[0].tipoMenu.value;
		var tiposMenus=document.forms[0].tipoMenu;
		var tipoMenuText=tiposMenus.options[tiposMenus.selectedIndex].text;
		
		if(idMenuPadre!=0 && nivel==0){
			alert("El nivel tiene que ser 1");
			return false;
		}
		
		if(idMenuPadre==0 && nivel==1){
			alert("El nivel tiene que ser 0");
			return false;
		}
		
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
			document.getElementById("btnGrabar").disabled=true;
			return false;
		}
}



