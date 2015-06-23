package curso.tecnocom.gestor.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.ContenidoDao;

@Service
public class ContenidoService {
	
	@Autowired
	private ContenidoDao gestorDao;
	

	@SuppressWarnings("rawtypes")
	public List<?> dameDatos(Class<?> clase) throws Exception {
		List salida=null;
		Method metodo=getGestorDao().getClass().getMethod("dameDatos", Class.class);
		salida=(List<?>) metodo.invoke(getGestorDao(), clase);
		return salida;
	}
	
	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		Method metodo=getGestorDao().getClass().getMethod("dameObjeto", int.class, Class.class);
		return metodo.invoke(getGestorDao(), id, clase);
	}
	
	
	public ContenidoDao getGestorDao() {
		return gestorDao;
	}

	public void setGestorDao(ContenidoDao gestorDao) {
		this.gestorDao = gestorDao;
	}

	public void grabaObjeto(Object objeto) throws Exception{
		Method metodo=getGestorDao().getClass().getMethod("grabaObjeto", Object.class);
		metodo.invoke(getGestorDao(), objeto);
		
	}


}
