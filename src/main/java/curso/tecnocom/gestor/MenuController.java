package curso.tecnocom.gestor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.datos.ContenidoProperty;
import curso.tecnocom.gestor.datos.Imagene;
import curso.tecnocom.gestor.datos.ImagenesProperty;
import curso.tecnocom.gestor.datos.Menu;
import curso.tecnocom.gestor.datos.MenuProperty;
import curso.tecnocom.gestor.datos.TipoMenu;
import curso.tecnocom.gestor.datos.TipoMenuProperty;
import curso.tecnocom.gestor.delegates.MenuDelegate;

@Controller
public class MenuController {

	@Autowired
	private MenuDelegate menuDelegate;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(TipoMenu.class, new TipoMenuProperty());
		binder.registerCustomEditor(Imagene.class, new ImagenesProperty());
		binder.registerCustomEditor(Contenido.class, new ContenidoProperty());
		binder.registerCustomEditor(Menu.class, new MenuProperty());
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("menu.html")
	public ModelAndView menu() {
		try {
			List<Menu> menus = (List<Menu>) getMenuDelegate().dameDatos(
					Menu.class);
			ModelAndView modelAndView = new ModelAndView("menus");
			modelAndView.addObject("menus", menus);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("modificaMenu.html")
	public ModelAndView modificaMenu(int id) {
		Menu menu = null;
		if (id == 0)
			menu = new Menu();
		try {
			if (id > 0)
				menu = (Menu) getMenuDelegate().dameObjeto(id);
			List<TipoMenu> tiposMenus = (List<TipoMenu>) getMenuDelegate()
					.dameDatos(TipoMenu.class);
			List<Imagene> imagenes = (List<Imagene>) getMenuDelegate()
					.dameDatos(Imagene.class);
			List<Contenido> contenidos = (List<Contenido>) getMenuDelegate()
					.dameDatos(Contenido.class);
			List<Menu> menus = (List<Menu>) getMenuDelegate().dameDatos(
					Menu.class);
			ModelAndView modelAndView = new ModelAndView("modificaMenu");
			modelAndView.addObject("menu", menu);
			modelAndView.addObject("tiposMenus", tiposMenus);
			modelAndView.addObject("menus", menus);
			modelAndView.addObject("imagenes", imagenes);
			modelAndView.addObject("contenidos", contenidos);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("grabaMenu.html")
	public ModelAndView grabaMenu(Menu menu, BindingResult result) {
		try {
			getMenuDelegate().modificaObjeto(menu);
			return menu();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("borraMenu.html")
	public ModelAndView borraMenu(int id) {
		try {
			getMenuDelegate().borrar(id);
			return menu();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public MenuDelegate getMenuDelegate() {
		return menuDelegate;
	}

	public void setMenuDelegate(MenuDelegate menuDelegate) {
		this.menuDelegate = menuDelegate;
	}

}
