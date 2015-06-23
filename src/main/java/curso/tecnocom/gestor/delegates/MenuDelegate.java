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

	public List<?> dameDatos() throws Exception {
		return getMenuService().dameDatos();
	}

	public void borrar(int id) throws Exception {
		getMenuService().borrar(id);
	}

	public Object dameObjeto(int id) throws Exception {
		return getMenuService().dameObjeto(id);
	}

	public void modificaObjeto(Object mod) throws Exception {
		getMenuService().modificaObjeto(mod);
	}
}
