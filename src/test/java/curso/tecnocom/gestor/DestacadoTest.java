package curso.tecnocom.gestor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Destacado;

public class DestacadoTest {
	

	@Autowired
	private DestacadoController destacadoControler;
	private Destacado destacado;

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void listado() {
		try {
			assertNotNull(getDestacadoControler().getGestorDelegate().dameDatos(Destacado.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		/*ModelAndView model = destacadoControler.destacados();
		if(model.getViewName().equals("error")){
			fail();
		}*/
	}

	public DestacadoController getDestacadoControler() {
		return destacadoControler;
	}

	public void setDestacadoControler(DestacadoController destacadoControler) {
		this.destacadoControler = destacadoControler;
	}

	public Destacado getDestacado() {
		return destacado;
	}

	public void setDestacado(Destacado destacado) {
		this.destacado = destacado;
	}
}
