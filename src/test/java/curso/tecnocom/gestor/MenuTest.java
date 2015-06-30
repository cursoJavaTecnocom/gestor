package curso.tecnocom.gestor;


import static org.junit.Assert.assertNotNull;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class MenuTest {
	
	@Autowired
	private MenuController menuController;
	private Menu menu=new Menu();
	
	@Test
	public void alta(){
		try {
			Contenido contenido=(Contenido) getMenuController().getDelegate().dameObjeto(19,Contenido.class);
			TipoMenu tipoMenu=(TipoMenu) getMenuController().getDelegate().dameObjeto(3,TipoMenu.class);
			Imagene imagen=(Imagene) getMenuController().getDelegate().dameObjeto(1,Imagene.class);
			menu.setContenido(contenido);
			menu.setIdMenuPadre(0);
			menu.setImagene(imagen);
			menu.setTipoMenu(tipoMenu);
			menu.setTitulo("Menu nuevo");
			getMenuController().getDelegate().grabaObjeto(menu);
			
//			getMenu().setTitulo("Titulo modificado");
//			getMenuController().getMenuDelegate().modificaObjeto(getMenu());
		} catch (Exception e) {
			//Assert.fail();
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	public void listado(){
		try {
			assertNotNull(getMenuController().getDelegate().dameDatos(Menu.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void listado1(){
		ModelAndView model=getMenuController().menu();
		if(model.getViewName().equals("error"))
			Assert.fail();
	}
	
		
	@Test
	public void borrado(){
		try {
			getMenuController().getDelegate().borraDato(22);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}

		
	public MenuController getMenuController(){
		return this.menuController;
	}
	
	public void setMenuController(MenuController controller){
		this.menuController=controller;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
}
