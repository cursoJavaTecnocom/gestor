package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.tecnocom.gestor.services.UsuarioService;

@Component
public class UsuarioDelegate {

	@Autowired
	private UsuarioService usuarioService;

	//DAME DATOS
	
	public List<?> dameDatos(Class<?> clase)throws Exception{
		return getUsuarioService().dameDatos(clase);
	}
	
	//DAME OBJETOS
	
	public Object dameObjeto(int id, Class<?> clase) throws Exception{
		return getUsuarioService().dameObjeto(id, clase);
	}
	
	//BORRAR
	
	public void borrar(int id,Class<?> clase) throws Exception {
		getUsuarioService().borrar(id,clase);

	}
	
	//GRABAR  
	
	public void grabaObjeto(Object objeto) throws Exception {
		getUsuarioService().grabaObjeto(objeto);
		
	}
	
	//GETTERS AND SETTERS
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}	
}
