package curso.tecnocom.gestor;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.datos.Menu;
import curso.tecnocom.gestor.datos.Noticia;
import curso.tecnocom.gestor.delegates.GestorDelegate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")

public class NoticiasTest {

	@Autowired
	private NoticiasController controler;	
	private  Noticia noticia;
	
	private GestorDelegate delegate;
	
	 
	
	
	@Test
	public void listaNoticias() {
		try {
			assertNotNull(getDelegate().dameDatos(Contenido.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	

	

	@Test
	public void borraNoticia(String id){
		
		try {			
			getDelegate().borraDato(8, Noticia.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void alta(){
		
		setNoticia(new Noticia());
		
		try{
			//getNoticia().setContenido("contenido de prueba para el área de NOTICIAS");
			getNoticia().setFecha("01072015");
			//getNoticia().setId(id);
			getNoticia().setTexto("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
			getNoticia().setTitulo("Lorem ipsum");
			getControler().getGestorDelegate().grabaObjeto(getNoticia());
			
		}catch (Exception e) {			
			e.printStackTrace();
			Assert.fail();
		}
		
		
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(curso.tecnocom.gestor.datos.Noticia noticia) {
		this.noticia = noticia;
	}

	public void setControler(NoticiasController controler) {
		this.controler = controler;
	}

	public NoticiasController getControler() {
		return controler;
	}




	public GestorDelegate getDelegate() {
		return delegate;
	}




	public void setDelegate(GestorDelegate delegate) {
		this.delegate = delegate;
	}

	
}
