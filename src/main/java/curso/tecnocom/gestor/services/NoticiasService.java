package curso.tecnocom.gestor.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.NoticiasDao;

@Service
public class NoticiasService {
 
	/***** Propiedades de la clase *****/
	@Autowired
	private NoticiasDao noticiasDao;
	
	public List<?>dameDatos(Class<?> clase) throws Exception
	{
		List<?>salida=null;
		Method metodo = getNoticiasDao().getClass().getMethod("dameDatos", Class.class);
		salida = (List<?>) metodo.invoke(getNoticiasDao(), clase);

		return salida;
	}
	
	public NoticiasDao getNoticiasDao(){
		return noticiasDao;
	}
	
	public void setNoticiasDao(NoticiasDao noticiasDao){		
		this.noticiasDao=noticiasDao;
	}
	
	public void borrar(int id, Class<?>clase) throws Exception{
		Method metodo=getNoticiasDao().getClass().getMethod("borrar",int.class,Class.class);
		metodo.invoke(getNoticiasDao(), id,clase);
	}
	
	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		Method metodo=getNoticiasDao().getClass().getMethod("dameObjeto", int.class, Class.class);
		 return metodo.invoke(getNoticiasDao(), id,clase);
	}
	

	public void grabaObjeto(Object objeto) throws Exception{
		Method metodo=getNoticiasDao().getClass().getMethod("grabaObjeto", Object.class);
		metodo.invoke(getNoticiasDao(), objeto);
		
	}


	
	
	
}
