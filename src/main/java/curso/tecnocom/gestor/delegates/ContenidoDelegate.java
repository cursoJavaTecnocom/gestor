package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.tecnocom.gestor.services.ContenidoService;

@Component
public class ContenidoDelegate {

	@Autowired
	private ContenidoService gestorService;
	
	public List<?> dameDatos(Class<?> clase) throws Exception{
		return getGestorService().dameDatos(clase);
	}
	
	public Object dameObjeto(int id, Class<?> clase) throws Exception{
		return getGestorService().dameObjeto(id, clase);
	}
	
	public void grabaObjeto(Object objeto) throws Exception{
		getGestorService().grabaObjeto(objeto);
		
	}
	

	public ContenidoService getGestorService() {
		return gestorService;
	}

	public void setGestorService(ContenidoService gestorService) {
		this.gestorService = gestorService;
	}
	
}
