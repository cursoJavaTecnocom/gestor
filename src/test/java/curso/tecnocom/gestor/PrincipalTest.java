package curso.tecnocom.gestor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import curso.tecnocom.gestor.daos.GestorDao;
import curso.tecnocom.gestor.datos.Principale;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class PrincipalTest {

	
	@Autowired
	private PrincipalController principalController;
	private Principale principale;
	@Autowired
	private GestorDao gestorService;
	
	
public GestorDao getGestorService() {
		return gestorService;
	}





	public void setGestorService(GestorDao gestorService) {
		this.gestorService = gestorService;
	}





	/*
	@Test
	public void listado()
	{
		try {
			assertNotNull(getPrincipalController().getPrincipalDelegate().dameDatos(Principale.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	*/
	@Test
	public void listado1() {
		
		try {
			List<?> salida=getGestorService().dameDatos(Principale.class);
		System.out.println(getGestorService().getSesion());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			Assert.fail();
		}

	}
	
	
	
	
	
	public PrincipalController getPrincipalController() {
		return principalController;
	}
	public void setPrincipalController(PrincipalController principalController) {
		this.principalController = principalController;
	}
	public Principale getPrincipale() {
		return principale;
	}
	public void setPrincipale(Principale principale) {
		this.principale = principale;
	}
	
	
	
	
}
