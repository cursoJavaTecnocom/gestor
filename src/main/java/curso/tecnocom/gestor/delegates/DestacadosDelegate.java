package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import curso.tecnocom.gestor.services.DestacadosService;

@Controller
public class DestacadosDelegate {
	
	/***** Propiedades de la clase *****/
	@Autowired
	private DestacadosService destacadosService;

	
	public List<?> recuperaDatos(Class<?> clase) throws Exception
	{
		
		return getDestacadosService().recuperaDatos(clase);
	}
	
	public Object recuperaObjeto(int id, Class<?> clase) throws Exception
	{
		
		return getDestacadosService().recuperaObjeto(id,clase);
		
	}
	
	public void borraObjeto(int id, Class<?> clase) throws Exception
	{
		
		getDestacadosService().borraObjeto(id,clase);
	}
	
	public void grabaObjeto(Object objeto) throws Exception
	{
		
		getDestacadosService().grabaObjeto(objeto);
	}
	
	
	/***** Métodos Get/Set *****/
	public DestacadosService getDestacadosService() {
		return destacadosService;
	}

	public void setDestacadosService(DestacadosService destacadosService) {
		this.destacadosService = destacadosService;
	}
	
	
	
	
	
	

}
