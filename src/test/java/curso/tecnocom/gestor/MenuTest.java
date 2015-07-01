package curso.tecnocom.gestor;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.MenuController;
import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.datos.Imagene;
import curso.tecnocom.gestor.datos.Menu;
import curso.tecnocom.gestor.datos.TipoMenu;
import curso.tecnocom.gestor.delegates.GestorDelegate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class MenuTest {
	
	@Autowired
	private GestorDelegate delegate;
	
	private Menu menu=new Menu();
	
	@Test
	public void alta(){
		try {
			Contenido contenido=(Contenido) getDelegate().dameObjeto(19,Contenido.class);
			TipoMenu tipoMenu=(TipoMenu) getDelegate().dameObjeto(3,TipoMenu.class);
			Imagene imagen=(Imagene) getDelegate().dameObjeto(1,Imagene.class);
			menu.setContenido(contenido);
			menu.setIdMenuPadre(0);
			menu.setImagene(imagen);
			menu.setTipoMenu(tipoMenu);
			menu.setTitulo("Menu nuevo");
			getDelegate().grabaObjeto(getMenu());
						
		} catch (Exception e) {
			//Assert.fail();
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	
	@Test
	public void listado(){
		try {
			assertNotNull(getDelegate().dameDatos(Menu.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
		
	@Test
	public void borrado(){
		try {
			getDelegate().borraDato(29,Menu.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	

	@Test
	public void modificar(){
		Menu menu;
		try {
			menu = (Menu) getDelegate().dameObjeto(29, Menu.class);
			getDelegate().grabaObjeto(menu);
		} catch (Exception e) {			
			e.printStackTrace();
			Assert.fail();
		}
	}

	public Menu getMenu() {
		return menu;
	}


	public GestorDelegate getDelegate() {
		return delegate;
	}


	public void setDelegate(GestorDelegate delegate) {
		this.delegate = delegate;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
}
