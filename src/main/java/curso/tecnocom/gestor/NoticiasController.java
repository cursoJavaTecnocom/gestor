package curso.tecnocom.gestor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.datos.ContenidoProperty;
import curso.tecnocom.gestor.datos.Noticia;
import curso.tecnocom.gestor.datos.NoticiaProperty;
import curso.tecnocom.gestor.delegates.GestorDelegate;


@Controller
public class NoticiasController {

	@Autowired
	private GestorDelegate gestorDelegate;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Noticia.class, new NoticiaProperty());
		binder.registerCustomEditor(Contenido.class, new ContenidoProperty());
	}

	// /----noticias
	@RequestMapping("noticias.html")
	public ModelAndView noticias(HttpServletRequest request) {
	/*	if (!getGestorDelegate().validar(request))
			return new ModelAndView("noLogado");*/
		try {
			List<Noticia> noticias = (List<Noticia>) getGestorDelegate().dameDatos(Noticia.class);
			/*Set<Noticia> noticiasOrdenados = new TreeSet<Noticia>();
			for (Noticia noticia : noticias) { 
				noticiasOrdenados.add(noticia);
			}*/
			ModelAndView salida = new ModelAndView("noticias");
			salida.addObject("noticias", noticias);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	// /----modificar
	@RequestMapping("modificaNoticia.html")
	public ModelAndView modificaNoticia(int id, HttpServletRequest request) {
//		if (!getGestorDelegate().validar(request))
//			return new ModelAndView("noLogado");
		Noticia noticia;	
		try {
			if (id == 0)
				noticia = new Noticia();
			else
				noticia = (Noticia) getGestorDelegate().dameObjeto(id, Noticia.class);
			
			ModelAndView salida = new ModelAndView("modificarNoticia");
			
			List<Contenido> contenidos = (List<Contenido>) getGestorDelegate().dameDatos(Contenido.class);
			
			salida.addObject("contenidos", contenidos);
			salida.addObject("noticia", noticia);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	// /----borrar
	@RequestMapping("borraNoticia.html")
	public ModelAndView borraNoticia(int id, HttpServletRequest request) {
//		if (!getGestorDelegate().validar(request))
//			return new ModelAndView("noLogado");
		try {
			getGestorDelegate().borraDato(id, Noticia.class);
			return noticias(request);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// /----grabar
	@RequestMapping("grabaNoticia.html")
	public ModelAndView grabaNoticia(Noticia noticia, HttpServletRequest request) {
//		if (!getGestorDelegate().validar(request))
//			return new ModelAndView("noLogado");
		try {
			getGestorDelegate().grabaObjeto(noticia);
			return noticias(request);
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
