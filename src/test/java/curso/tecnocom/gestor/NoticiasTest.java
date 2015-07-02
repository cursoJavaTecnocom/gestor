package curso.tecnocom.gestor;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Noticia;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")

public class NoticiasTest {

	@Autowired
	private NoticiasController controler;
	
	private  Noticia noticia;
	
	
	
	
	@Test
	public void listaNoticias(HttpServletRequest request) {
		
		request.getSession(true).setAttribute("logado", true);
		
		ModelAndView model = controler.noticias(request);
		if (model.getViewName().equals("error"))
			fail();
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

	
}
