package curso.tecnocom.gestor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Destacado;
import curso.tecnocom.gestor.delegates.DestacadosDelegate;

@Controller
public class DestacadoController {

	private static final Logger logger = LoggerFactory
			.getLogger(DestacadoController.class);

	@Autowired
	private DestacadosDelegate destacadosDelegate;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "destacados";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("destacados.gin")
	public ModelAndView destacados() {
		try {
			List<Destacado> destacados = (List<Destacado>) getDestacadosDelegate()
					.recuperaDatos(Destacado.class);
			ModelAndView salida = new ModelAndView("destacados");
			salida.addObject("destacados", destacados);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	@RequestMapping("borraDestacado.gin")
	public ModelAndView borraDestacado(int id) {
		try {
			getDestacadosDelegate().borraObjeto(id, Destacado.class);
			return destacados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	@RequestMapping("modificaDestacado.gin")
	public ModelAndView modificaDestacado(int id) {
		Destacado destacado = null;
		if (id == 0) {
			destacado = new Destacado();
		}
		try {
			if (id > 0)
				destacado = (Destacado) getDestacadosDelegate().recuperaObjeto(
						id, Destacado.class);

			ModelAndView salida = new ModelAndView("modificaDestacado");
			salida.addObject("destacado", destacado);
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	public DestacadosDelegate getDestacadosDelegate() {
		return destacadosDelegate;
	}

	public void setDestacadoDelegate(DestacadosDelegate destacadosDelegate) {
		this.destacadosDelegate = destacadosDelegate;
	}

}
