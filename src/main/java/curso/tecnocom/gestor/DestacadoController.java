package curso.tecnocom.gestor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Destacado;
import curso.tecnocom.gestor.delegates.GestorDelegate;

@Controller
public class DestacadoController {

	
	private static final Logger logger = LoggerFactory
			.getLogger(DestacadoController.class);

	@Autowired
	private GestorDelegate gestorDelegate;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping("destacados.html")
	public ModelAndView destacados() {
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
	public ModelAndView borraDestacado(int id) {
		try {
			getGestorDelegate().borraDato(id, Destacado.class);
			return destacados();
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
			salida.addObject("destacado", destacado);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	@RequestMapping("grabaDestacado.html")
	public ModelAndView grabaEmpresa(Destacado destacado, String titulo,
			String texto) {
		try {
			getGestorDelegate().grabaObjeto(destacado);
			return destacados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			destacado.setTitulo(titulo);
			destacado.setTexto(texto);
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
