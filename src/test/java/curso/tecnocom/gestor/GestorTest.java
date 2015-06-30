package curso.tecnocom.gestor;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.services.GestorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")

public class GestorTest {

@Autowired
private GestorService contenidoService;
	
	public GestorService getContenidoService() {
	return contenidoService;
}

public void setContenidoService(GestorService contenidoService) {
	this.contenidoService = contenidoService;
}

	@Test
	public void prueba() {
		
		try {
			List<?> elementos= getContenidoService().dameDatos(Contenido.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

		
}
