package curso.tecnocom.gestor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tecnocom.curso.empresa.HomeController;
import curso.tecnocom.gestor.datos.Usuario;


@Controller
public class UsuariosController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UsuariosController.class);
	
	private UsuarioDelegate usuarioDelegate;
	
	@RequestMapping("usuarios.gin")
	public ModelAndView usuarios()
	{
		List<Usuario> usuarios = getUsuarioDelegate().dameDatos(Usuario.class);
		Set<Usuario> usuariosordenados= TreeSet<Usuario>();
		
		for(Usuario usuario : usuarios){
			usuariosordenados.add(usuario);
		}
			ModelAndView salida= ModelAndView("usuarios");
			salida.addObject("usuario", usuariosordenados);
			
		
		
		
		
		
		
	}

	public UsuarioDelegate getUsuarioDelegate() {
		return usuarioDelegate;
	}

	public void setUsuarioDelegate(UsuarioDelegate usuarioDelegate) {
		this.usuarioDelegate = usuarioDelegate;
	}
	
		
	

}
