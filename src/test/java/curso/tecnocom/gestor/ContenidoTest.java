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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")



public class ContenidoTest {
	
	@Autowired
	private ContenidoController contenidoController;
	
	private Contenido contenido;
	
	
	public ContenidoController getContenidoController() {
		return contenidoController;
	}

	public void setContenidoController(ContenidoController contenidoController) {
		this.contenidoController = contenidoController;
	}

	public Contenido getContenido() {
		return contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	
	
	
	
	
/*	@Test
	public void alta(){
		setContenido(new Contenido());
		try{
			Contenido cont=(Contenido) getContenidoController().getContenidoDelegate().dameObjeto(19, Contenido.class);
			
			getContenido().setContenido("jkashdklajsdhlkajhsdklajdhskaj");
			getContenido().setDescripcion("rebajas");
			getContenidoController().getContenidoDelegate().grabaObjeto(getContenido());
			
			
			
		}catch (Exception e) {
			//Assert.fail();
			e.printStackTrace();
			Assert.fail();
		}
		
		
	}
	
	@Test
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
		ModelAndView model=getContenidoController().contenido();
		if(model.getViewName().equals("error"))
			Assert.fail();
	}
	

}
