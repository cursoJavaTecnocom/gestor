package curso.tecnocom.gestor.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.UsuarioDao;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	//GRABA OBJETO
	public void grabaObjeto(Object objeto) throws Exception {
		Method metodo=getUsuarioDao().getClass().getMethod("grabaObjeto", Object.class);
		metodo.invoke(getUsuarioDao(), objeto);	
	}
	
	//DAR DATOS
	public List<?> dameDatos(Class<?> clase) throws Exception {
		
		List<?> salida = null;
		Method metodo = getUsuarioDao().getClass().getMethod("dameDatos", Class.class);
		salida =  (List<?>) metodo.invoke(getUsuarioDao(), clase);
		return  salida;
	}
	
	//BORRAR
	public void borrar(int id,Class<?> clase) throws Exception{
		Method metodo = getUsuarioDao().getClass().getMethod("borrar", int.class, Class.class);
		metodo.invoke(getUsuarioDao(), id, clase);
	}
	
	//DAR OBJETO
	public Object dameObjeto(int id, Class<?> clase) throws Exception{
		Method metodo= getUsuarioDao().getClass().getMethod("dameObjeto", int.class ,Class.class);
		return metodo.invoke(getUsuarioDao(), id, clase);		
	}
	
	
	//GETTERS AND SETTERS
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
