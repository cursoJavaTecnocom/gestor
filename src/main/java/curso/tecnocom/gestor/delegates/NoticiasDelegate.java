package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.tecnocom.gestor.services.NoticiasService;

@Component
public class NoticiasDelegate {

	@Autowired
	private NoticiasService noticiasService;

	//DAME DATOS
	public List<?> dameDatos(Class<?> clase)throws Exception{
		return getNoticiasService().dameDatos(clase);
	}
	
	//DAME OBJETOS
	public Object dameObjeto(int id, Class<?> clase) throws Exception{
		return getNoticiasService().dameObjeto(id, clase);
	}
	
	//BORRAR	
	public void borrar(int id,Class<?> clase) throws Exception {
		getNoticiasService().borrar(id,clase);

	}
	
	//GRABAR
	public void grabaObjeto(Object objeto) throws Exception {
		getNoticiasService().grabaObjeto(objeto);
		
	}
	
	//GETTERS AND SETTERS
	public NoticiasService getNoticiasService() {
		return noticiasService;
	}
	public void setNoticiasService(NoticiasService noticiasService) {
		this.noticiasService = noticiasService;
	}	
}
