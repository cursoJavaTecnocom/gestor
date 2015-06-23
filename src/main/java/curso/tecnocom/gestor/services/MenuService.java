package curso.tecnocom.gestor.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.MenuDao;

@Service
public class MenuService {
	@Autowired
	private MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List<?> dameDatos(Class<?> clase) throws Exception {
		List<?> salida = null;

		Method metodo = getMenuDao().getClass().getMethod("dameDatos",
				Class.class);
		salida = (List<?>) metodo.invoke(getMenuDao(), clase);
		return salida;
	}

	public void borrar(int id, Class<?> clase) throws Exception {
		Method metodo = getMenuDao().getClass().getMethod("borrar", int.class,
				Class.class);
		metodo.invoke(getMenuDao(), id, clase);

	}

	public Object dameObjeto(int id, Class<?> class1) throws Exception {
		Method metodo = getMenuDao().getClass().getMethod("dameObjeto",
				int.class, Class.class);
		return metodo.invoke(getMenuDao(), id, class1);
	}

	public void modificaObjeto(Object mod) throws Exception {
		Method metodo = getMenuDao().getClass().getMethod("modificar",
				Object.class);
		metodo.invoke(getMenuDao(), mod);

	}
}
