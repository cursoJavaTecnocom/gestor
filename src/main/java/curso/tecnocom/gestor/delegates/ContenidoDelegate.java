package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.services.ContenidoService;

@Component
public class ContenidoDelegate {
	
	@Autowired
	private ContenidoService contenidoService;


	public ContenidoService getContenidoService() {
		return contenidoService;
	}
	public void setContenidoService(ContenidoService contenidoService) {
		this.contenidoService = contenidoService;
	}
	public List<Contenido> getContenidoFooter() throws Exception {
		// TODO Auto-generated method stub
		return getContenidoService().getContenidoFooter();
	}
	public List<Contenido> getContenidoHeader() throws Exception {
		// TODO Auto-generated method stub
		return getContenidoService().getContenidoHeader();
	}

}
