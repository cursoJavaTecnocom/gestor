package curso.tecnocom.gestor.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import curso.tecnocoom.gestor.daos.DestacadosDao;

public class DestacadosService {

	/***** Propiedades de la clase *****/
	@Autowired
	private DestacadosDao destacadosDao;
	
	
	public List<?> recuperaDatos(Class<?> clase) throws Exception {
		
		List<?> salida=null;
		
		Method metodo=getDestacadosDao().getClass().getMethod("recuperaDatos", Class.class);
		salida=(List<?>) metodo.invoke(getDestacadosDao(), clase);
		
		return salida;
	}
	

	public Object recuperaObjeto(int id, Class<?> clase) throws Exception {
		
		Method metodo=getDestacadosDao().getClass().getMethod("recuperaObjeto", int.class,Class.class);
		return metodo.invoke(getDestacadosDao(), id, clase);
		
	}
	
	public void borraObjeto(int id, Class<?> clase) throws Exception {
		
		Method metodo=getDestacadosDao().getClass().getMethod("borraObjeto", int.class,Class.class);
		metodo.invoke(getDestacadosDao(), id, clase);
		
	}
	
	public void grabaObjeto(Object objeto) throws Exception {
		
		
		Method metodo=getDestacadosDao().getClass().getMethod("grabaObjeto", Object.class);
		metodo.invoke(getDestacadosDao(), objeto);
		
	}
	
	/***** Métodos Get/Set *****/
	public DestacadosDao getDestacadosDao() {
		return destacadosDao;
	}

	public void setDestacadosDao(DestacadosDao destacadosDao) {
		this.destacadosDao = destacadosDao;
	}




	



	
	
	
	
}
