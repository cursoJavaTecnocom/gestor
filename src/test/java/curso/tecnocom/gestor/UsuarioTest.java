package curso.tecnocom.gestor;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")

public class UsuarioTest {

	@Autowired
	private UsuariosController controler;
	
	private  curso.tecnocom.gestor.datos.Usuario usuario;
	
	
	
	
	@Test
	public void listaUsuario() {
		
		try {
			assertNotNull(controler.getUsuarioDelegate().dameDatos(UsuarioTest.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
		
		
	}
	
//	@Test
//	public void altaUsuario() {
//		
//		setUsuario(new curso.tecnocom.gestor.datos.Usuario());
//		
//		Usuario usuario= getControler().getUsuarioDelegate().dameObjeto(id, Usuario.class);
//		
//		fail("Not yet implemented");
//	}

	public UsuariosController getControler() {
		return controler;
	}

	public void setControler(UsuariosController controler) {
		this.controler = controler;
	}

	public curso.tecnocom.gestor.datos.Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(curso.tecnocom.gestor.datos.Usuario usuario) {
		this.usuario = usuario;
	}

	
}
