package curso.tecnocom.gestor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.delegates.GestorDelegate;

@Controller
public class ContenidoController {

	private static final Logger logger = LoggerFactory
			.getLogger(DestacadoController.class);

	@Autowired
	private GestorDelegate contenidoDelegate;

	@SuppressWarnings("unchecked")
	@RequestMapping("contenidos.html")
	public ModelAndView contenido(HttpServletRequest request) {
		if (!getContenidoDelegate().validar(request))
			return new ModelAndView("noLogado");

		try {
			List<Contenido> contenidos = (List<Contenido>) getContenidoDelegate()
					.dameDatos(Contenido.class);

			ModelAndView salida = new ModelAndView("contenidos");
			salida.addObject("contenidos", contenidos);
			return salida;
		} catch (Exception e) {

			return new ModelAndView("home");
		}

	}

	

	@RequestMapping("modificaContenido.html")
	public ModelAndView modificaContenido(int id,HttpServletRequest request) {
		if (getContenidoDelegate().validar(request))
			return new ModelAndView("noLogado");
		try {
			if (id == 0) {
				Contenido contenido = new Contenido();
			} else {
				Contenido contenido = (Contenido) getContenidoDelegate()
						.dameDatos(Contenido.class);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView salida = new ModelAndView("modificaContenido");
		return salida;

	}

	@RequestMapping("grabaContenido.html")
	public ModelAndView grabaContenido(Contenido contenido,HttpServletRequest request) {
		if (getContenidoDelegate().validar(request))
			return new ModelAndView("noLogado");
		try {
			getContenidoDelegate().grabaObjeto(contenido);
			return contenido(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ModelAndView("error");
		}
	}

	public GestorDelegate getContenidoDelegate() {
		return contenidoDelegate;
	}

	public void setContenidoDelegate(GestorDelegate contenidoDelegate) {
		this.contenidoDelegate = contenidoDelegate;
	}
}
