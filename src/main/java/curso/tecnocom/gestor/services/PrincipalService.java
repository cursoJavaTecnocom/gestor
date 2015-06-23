package curso.tecnocom.gestor.services;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.PrincipalDao;


@Service
public class PrincipalService {

	
	@Autowired
	private PrincipalDao principalDao;
	
	
	
	public List<?> dameDatos(Class clase) throws Exception
	{
		
		
		List<?> salida=null;
		Method metodo=getPrincipalDao().getClass().getMethod("dameDatos", Class.class);
		salida=(List<?>) metodo.invoke(getPrincipalDao(), clase);
		return salida;
	}
	
	
	public Object dameObjeto(int id, Class<?> clase)throws Exception{
		Method metodo=getPrincipalDao().getClass().getMethod("dameObjeto", int.class,Class.class);
		return getPrincipalDao().dameObjeto(id, clase);
	}

	
	public void grabaObjeto(Object objeto) throws Exception {
		// TODO Auto-generated method stub
		Method metodo=getPrincipalDao().getClass().getMethod("grabaObjeto", Object.class);
		metodo.invoke(getPrincipalDao(),objeto);
		
	}
	
	
	public void borrar(int id, Class<?> clase) throws Exception{
		Method metodo=getPrincipalDao().getClass().getMethod("borrar", int.class,Class.class);
		metodo.invoke(getPrincipalDao(), id,clase);
	}
	
	
	
	
	
	
	

	public PrincipalDao getPrincipalDao() {
		return principalDao;
	}

	public void setPrincipalDao(PrincipalDao principalDao) {
		this.principalDao = principalDao;
	}
	
	
	
}
