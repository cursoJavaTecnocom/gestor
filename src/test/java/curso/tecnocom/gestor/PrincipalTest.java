package curso.tecnocom.gestor;

import static org.junit.Assert.assertNotNull;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import curso.tecnocom.gestor.datos.Principale;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class PrincipalTest {

	
	
	private PrincipalController principalController;
	private Principale principale;
	
	
	
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
