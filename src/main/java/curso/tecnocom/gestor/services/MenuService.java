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

	public void borrar(int id) throws Exception {
		Method metodo = getMenuDao().getClass().getMethod("borrar", int.class);
		metodo.invoke(getMenuDao(), id);

	}

	public Object dameObjeto(Class<?> clase, int id) throws Exception {
		Method metodo = getMenuDao().getClass().getMethod("dameObjeto",Class.class,int.class);
		return metodo.invoke(getMenuDao(), clase, id);
	}

	public void modificaObjeto(Object mod) throws Exception {
		Method metodo = getMenuDao().getClass().getMethod("modificar",Object.class);
		metodo.invoke(getMenuDao(), mod);

	}
}
