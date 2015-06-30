package curso.tecnocom.gestor;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import curso.tecnocom.gestor.MenuController;
import curso.tecnocom.gestor.datos.Menu;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
public class MenuTest {
	
	@Autowired
	private MenuController menuController;
	
//	@Test
//	public void alta(){
//		
//	}
//	
	
	@Test
	public void listado(){
		try {
			assertNotNull(getMenuController().getMenuDelegate().dameDatos(Menu.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test
//	public void borrado(){
//		
//	}
		
	public MenuController getMenuController(){
		return this.menuController;
	}
	
	public void setMenuController(MenuController controller){
		this.menuController=controller;
	}
}
