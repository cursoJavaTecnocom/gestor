package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import curso.tecnocom.gestor.services.MenuService;

public class MenuDelegate {

	@Autowired
	private MenuService menuService;

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public List<?> dameDatos(Class<?> clase) throws Exception {
		return getMenuService().dameDatos(clase);
	}

	public void borrar(int id, Class<?> clase) throws Exception {
		getMenuService().borrar(id, clase);
	}

	public Object dameObjeto(int id, Class<?> class1) throws Exception {
		return getMenuService().dameObjeto(id, class1);
	}

	public void modificaObjeto(Object mod) throws Exception {
		getMenuService().modificaObjeto(mod);
	}
}
