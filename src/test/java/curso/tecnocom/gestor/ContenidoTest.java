package curso.tecnocom.gestor;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.delegates.GestorDelegate;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")



public class ContenidoTest {
	
	@Autowired
	private GestorDelegate gestorDelegate;
	
	public GestorDelegate getGestorDelegate() {
		return gestorDelegate;
	}

	public void setGestorDelegate(GestorDelegate gestorDelegate) {
		this.gestorDelegate = gestorDelegate;
	}

	private Contenido contenido;
	
	
	

	public Contenido getContenido() {
		return contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	
	
	
	
	
	@Test
	public void alta(){
		setContenido(new Contenido());
		try{
			// Contenido cont=(Contenido) getContenidoController().getContenidoDelegate().dameObjeto(19, Contenido.class);
			
			// grabar en base de datos
			getContenido().setContenido("jkashdklajsdhlkajhsdklajdhskaj");
			getContenido().setDescripcion("rebajas");
			getGestorDelegate().grabaObjeto(getContenido());
			
			
			
		}catch (Exception e) {
			//Assert.fail();
			e.printStackTrace();
			Assert.fail();
		}
		
		
	}
	
/*	@Test
	public void listado(){
		try {
			assertNotNull(getContenidoController().getContenidoDelegate().dameDatos(Contenido.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	*/
	  
	@Test
	public void listado1(){
		try {
			getGestorDelegate().dameDatos(Contenido.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	

}
