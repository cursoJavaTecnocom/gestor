package curso.tecnocom.gestor.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import curso.tecnocom.gestor.daos.DaoInterface;

import curso.tecnocom.gestor.daos.GestorDao;

@Service
public class GestorService {
	
	@Autowired
	private GestorDao contenidoDao;
	

	
	public List<?> dameDatos(Class<?> clase) throws Exception {
		List<?> salida=null;
		Method metodo=getContenidoDao().getClass().getMethod("dameDatos", Class.class);
		salida=(List<?>) metodo.invoke(getContenidoDao(), clase);
		// return getContenidoDao().dameDatos(clase);
		return salida;
	}
	
	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		Method metodo=getContenidoDao().getClass().getMethod("dameObjeto", int.class, Class.class);
		return metodo.invoke(getContenidoDao(), id, clase);
	}
	
	

	public void grabaObjeto(Object objeto) throws Exception{
		Method metodo=getContenidoDao().getClass().getMethod("grabaDato", Object.class);
		metodo.invoke(getContenidoDao(), objeto);
		
	}

	public void borraDato(Object objeto) throws Exception{
		Method metodo=getContenidoDao().getClass().getMethod("borraDato", Object.class);
		metodo.invoke(getContenidoDao(), objeto);
		
	}

	public void borraDato(int id, Class<?> clase) throws Exception{
		Method metodo=getContenidoDao().getClass().getMethod("borraDato", int.class,Class.class);
		metodo.invoke(getContenidoDao(), id,clase);
		
	}




	public GestorDao getContenidoDao() {
		return contenidoDao;
	}

	public void setContenidoDao(GestorDao contenidoDao) {
		this.contenidoDao = contenidoDao;
	}

}
