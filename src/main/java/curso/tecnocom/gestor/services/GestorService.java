package curso.tecnocom.gestor.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.DaoInterface;

@Service
public class GestorService {
	
	@Autowired
	private DaoInterface contenidoDao;
	

	@SuppressWarnings("rawtypes")
	public List<?> dameDatos(Class<?> clase) throws Exception {
		List salida=null;
		Method metodo=getContenidoDao().getClass().getMethod("dameDatos", Class.class);
		salida=(List<?>) metodo.invoke(getContenidoDao(), clase);
		return salida;
	}
	
	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		Method metodo=getContenidoDao().getClass().getMethod("dameObjeto", int.class, Class.class);
		return metodo.invoke(getContenidoDao(), id, clase);
	}
	
	


	public DaoInterface getContenidoDao() {
		return contenidoDao;
	}

	public void setContenidoDao(DaoInterface contenidoDao) {
		this.contenidoDao = contenidoDao;
	}

	public void grabaObjeto(Object objeto) throws Exception{
		Method metodo=getContenidoDao().getClass().getMethod("grabaObjeto", Object.class);
		metodo.invoke(getContenidoDao(), objeto);
		
	}

	public void borraDato(Object objeto) throws Exception{
		Method metodo=getContenidoDao().getClass().getMethod("grabaObjeto", Object.class);
		metodo.invoke(getContenidoDao(), objeto);
		
	}

	public void borraDato(int id, Class<?> clase) throws Exception{
		Method metodo=getContenidoDao().getClass().getMethod("borraDato", int.class,Class.class);
		metodo.invoke(getContenidoDao(), id,clase);
		
	}


}
