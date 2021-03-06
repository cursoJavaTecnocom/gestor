package curso.tecnocom.gestor.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.ContenidoDao;
import curso.tecnocom.gestor.datos.Contenido;

@Service
public class ContenidoService {

	@Autowired
	private ContenidoDao contenidoDao;


	public ContenidoDao getContenidoDao() {
		return contenidoDao;
	}


	public void setContenidoDao(ContenidoDao contenidoDao) {
		this.contenidoDao = contenidoDao;
	}


	public List<Contenido> getContenidoFooter() throws Exception {
		List<Contenido> salida= null;
		Method metodo=getContenidoDao().getClass().getMethod("getContenidoFooter");
		salida=(List<Contenido>) metodo.invoke(getContenidoDao());
		
		return salida;
		
	}
	
	public List<Contenido> getContenidoHeader() throws Exception {
		List<Contenido> salida= null;
		Method metodo=getContenidoDao().getClass().getMethod("getContenidoHeader");
		salida=(List<Contenido>) metodo.invoke(getContenidoDao());
		
		return salida;
		
	}
}
