package curso.tecnocom.gestor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Noticia;
import curso.tecnocom.gestor.delegates.GestorDelegate;


@Controller
public class NoticiasController {

	@Autowired
	private GestorDelegate gestorDelegate;

	// /----noticias
	@RequestMapping("noticias.html")
	public ModelAndView noticias() {

		try {
			List<Noticia> noticias = (List<Noticia>) getGestorDelegate().dameDatos(Noticia.class);
			Set<Noticia> noticiasOrdenados = new TreeSet<Noticia>();
			for (Noticia noticia : noticias) {
				noticiasOrdenados.add(noticia);
			}
			ModelAndView salida = new ModelAndView("noticias");
			salida.addObject("noticias", noticiasOrdenados);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	// /----modificar
	@RequestMapping("modificaNoticia.html")
	public ModelAndView modificaPrincipal(int id) {
		Noticia noticia = null;
		if (id == 0) {
			noticia = new Noticia();
		}

		try {
			if (id > 0)
				noticia = (Noticia) getGestorDelegate().dameObjeto(id, Noticia.class);
			ModelAndView salida = new ModelAndView("modificarNoticia");
			salida.addObject("noticia", noticia);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	// /----añadir

	
	// /----borrar
	@RequestMapping("borraNoticia.gin")
	public ModelAndView borraMenu(int id) {
		try {
			getGestorDelegate().borraDato(id, Noticia.class);
			return noticias();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// /----grabar
	@RequestMapping("grabaNoticia.html")
	public ModelAndView grabaPrincipal(Noticia noticia) {
		try {
			getGestorDelegate().grabaObjeto(noticia);
			return noticias();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ModelAndView("error");
		}
	}



	public GestorDelegate getGestorDelegate() {
		return gestorDelegate;
	}
	public void setGestorDelegate(GestorDelegate gestorDelegate) {
		this.gestorDelegate = gestorDelegate;
	}
}
