package curso.tecnocom.gestor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")

public class NoticiasTest {

	@Autowired
	private NoticiasController controler;
	
	private  curso.tecnocom.gestor.datos.Noticia noticia;
	
	
	
	
	@Test
	public void listaNoticias() {
		
		ModelAndView model = controler.noticias();
		if (model.getViewName().equals("error"))
			fail();
	}
	



	public curso.tecnocom.gestor.datos.Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(curso.tecnocom.gestor.datos.Noticia noticia) {
		this.noticia = noticia;
	}

	public void setControler(NoticiasController controler) {
		this.controler = controler;
	}

	
}
