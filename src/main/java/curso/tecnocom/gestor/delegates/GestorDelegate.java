package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.tecnocom.gestor.services.GestorService;

@Component
public class GestorDelegate {

	@Autowired
	private GestorService gestorService;
	
	public List<?> dameDatos(Class<?> clase) throws Exception{
		return getGestorService().dameDatos(clase);
	}
	
	public Object dameObjeto(int id, Class<?> clase) throws Exception{
		return getGestorService().dameObjeto(id, clase);
	}
	
	public void grabaObjeto(Object objeto) throws Exception{
		getGestorService().grabaObjeto(objeto);
	}
	
	public GestorService getGestorService() {
		return gestorService;
	}

	public void setGestorService(GestorService gestorService) {
		this.gestorService = gestorService;
	}
	
	public void borraDato(Object objeto) throws Exception
	{
		getGestorService().borraDato( objeto);
	}
	public void borraDato(int id, Class<?> clase) throws Exception
	{
		getGestorService().borraDato( id,clase);
	}
}
