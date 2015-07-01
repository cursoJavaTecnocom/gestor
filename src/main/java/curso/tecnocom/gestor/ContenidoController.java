package curso.tecnocom.gestor;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import curso.tecnocom.gestor.delegates.GestorDelegate;

@Controller
public class ContenidoController {

	private static final Logger logger = LoggerFactory
			.getLogger(DestacadoController.class);

	@Autowired
	private GestorDelegate contenidoDelegate;
	
	@InitBinder
	public void init(WebDataBinder binder){

		binder.registerCustomEditor(Contenido.class, new ContenidoProperty());
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("contenidos.html")
	public ModelAndView contenido(HttpServletRequest request) {
		//if (!getContenidoDelegate().validar(request))
			//return new ModelAndView("noLogado");

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
		//if (getContenidoDelegate().validar(request))
			//return new ModelAndView("noLogado");
		try {
			Contenido contenido=null;
			if (id == 0) 
				contenido = new Contenido();
			 else 
				contenido = (Contenido) getContenidoDelegate().dameObjeto(id, Contenido.class);
			
			ModelAndView salida = new ModelAndView("modificaContenido");
			salida.addObject("contenido", contenido);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView ("error");
		}

		

	}

	@RequestMapping("grabaContenido.html")
	public ModelAndView grabaContenido(Contenido contenido,HttpServletRequest request, BindingResult result) {
		//if (getContenidoDelegate().validar(request))
			//return new ModelAndView("noLogado");
		try {
			getContenidoDelegate().grabaObjeto(contenido);
			return contenido(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("borraContenido.html")
	public ModelAndView borraContenido(int id, HttpServletRequest request){
		try {
			getContenidoDelegate().borraDato(id, Contenido.class);
			return contenido(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public GestorDelegate getContenidoDelegate() {
		return contenidoDelegate;
	}

	public void setContenidoDelegate(GestorDelegate contenidoDelegate) {
		this.contenidoDelegate = contenidoDelegate;
	}
}

