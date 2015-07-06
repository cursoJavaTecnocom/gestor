package curso.tecnocom.gestor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.datos.ContenidoProperty;
import curso.tecnocom.gestor.datos.Destacado;
import curso.tecnocom.gestor.datos.Imagene;
import curso.tecnocom.gestor.datos.Menu;
import curso.tecnocom.gestor.datos.Noticia;
import curso.tecnocom.gestor.datos.Principale;
import curso.tecnocom.gestor.datos.Usuario;
import curso.tecnocom.gestor.delegates.GestorDelegate;
import curso.tecnocom.gestor.delegates.ImagenesDelegate;

@Controller
public class DestacadoController {

	private static final Logger logger = LoggerFactory
			.getLogger(DestacadoController.class);

	@Autowired
	private GestorDelegate gestorDelegate;
	@Autowired
	private ImagenesDelegate imagenesDelegate;
	
	public ImagenesDelegate getImagenesDelegate() {
		return imagenesDelegate;
	}

	public void setImagenesDelegate(ImagenesDelegate imagenesDelegate) {
		this.imagenesDelegate = imagenesDelegate;
	}

	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		try {
			List<Menu> menus = (List<Menu>) getGestorDelegate().dameDatos(
					Menu.class);
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("menus", menus);
			List<Destacado> destacados = (List<Destacado>) getGestorDelegate().dameDatos(Destacado.class);
			modelAndView.addObject("destacados", destacados);
			List<Noticia> noticias = (List<Noticia>) getGestorDelegate().dameDatos(Noticia.class);
			modelAndView.addObject("noticias", noticias);
			List<Principale> principales = (List<Principale>) getGestorDelegate().dameDatos(Principale.class);
			modelAndView.addObject("principales", principales);
			List<Imagene> imagenesCarrusel= getImagenesDelegate().getImagenesByCarrusel();
			modelAndView.addObject("imagenesCarrusel", imagenesCarrusel);
			
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			return  new ModelAndView("error");
		}
	}
	
	@RequestMapping("home.html")
	public ModelAndView home(HttpServletRequest request){

		ModelAndView modelAndView= null;
		if (!getGestorDelegate().validar(request))
		{
			
			modelAndView= new ModelAndView("validacion");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("destino","home.html");
			return modelAndView;
		}
		return new ModelAndView("home");
	}

	@InitBinder
	public void init(WebDataBinder binder) 
	{
		binder.registerCustomEditor(Contenido.class, new ContenidoProperty());
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("destacados.html")
	public ModelAndView destacados(HttpServletRequest request) {
		if (!getGestorDelegate().validar(request))
		{
			
			ModelAndView modelAndView= new ModelAndView("validacion");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("destino","destacados.html");
			return modelAndView;
		}
		try {
			List<Destacado> destacados = (List<Destacado>) getGestorDelegate()
					.dameDatos(Destacado.class);
			ModelAndView salida = new ModelAndView("destacados");
			salida.addObject("destacados", destacados);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	@RequestMapping("borraDestacado.html")
	public ModelAndView borraDestacado(int id, HttpServletRequest request) {
		try {
			getGestorDelegate().borraDato(id, Destacado.class);
			return destacados(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	@RequestMapping("modificaDestacado.html")
	public ModelAndView modificaDestacado(int id) {
		Destacado destacado = null;
		if (id == 0) {
			destacado = new Destacado();
		}
		try {
			if (id > 0) {
				destacado = (Destacado) getGestorDelegate().dameObjeto(id,
						Destacado.class);
			}
			ModelAndView salida = new ModelAndView("modificaDestacado");
			List<Contenido> contenidos = (List<Contenido>) getGestorDelegate()
					.dameDatos(Contenido.class);
			salida.addObject("destacado", destacado);
			salida.addObject("contenidos", contenidos);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("grabaDestacado.html")
	public ModelAndView grabaEmpresa(Destacado destacado, String titulo,
			String texto, HttpServletRequest request) {
		try {
			getGestorDelegate().grabaObjeto(destacado);
			return destacados(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			destacado.setTitulo(titulo);
			destacado.setTexto(texto);
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("verDestacado.html")
	public ModelAndView verContenido(int id, HttpServletRequest request){
		try{
		Destacado destacado = null;
		destacado = (Destacado) getGestorDelegate().dameObjeto(id, Destacado.class);
		ModelAndView salida = new ModelAndView("verContenido");
		List<Menu> menus = (List<Menu>) getGestorDelegate().dameDatos(
				Menu.class);
		salida.addObject("menus", menus);
		salida.addObject("destacado", destacado);
		return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView ("error");
		}
		
	}

	public GestorDelegate getGestorDelegate() {
		return gestorDelegate;
	}

	public void setGestorDelegate(GestorDelegate gestorDelegate) {
		this.gestorDelegate = gestorDelegate;
	}

}
