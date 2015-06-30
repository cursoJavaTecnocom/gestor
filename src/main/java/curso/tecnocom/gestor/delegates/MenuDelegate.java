package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.tecnocom.gestor.services.MenuService;

@Component
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

	public void borrar(int id) throws Exception {
		getMenuService().borrar(id);
	}

	public Object dameObjeto(Class<?> clase, int id) throws Exception {
		return getMenuService().dameObjeto(clase, id);
	}

	public void modificaObjeto(Object mod) throws Exception {
		getMenuService().modificaObjeto(mod);
	}
}
