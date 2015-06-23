package curso.tecnocom.gestor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Usuario;

@Controller
public class UsuariosController {

	private static final Logger logger = LoggerFactory
			.getLogger(UsuariosController.class);

	private UsuarioDelegate usuarioDelegate;

	@RequestMapping("usuarios.gin")
	public ModelAndView usuarios()
	{
		try{
		List<Usuario> usuarios = getUsuarioDelegate().dameDatos(Usuario.class);
		Set<Usuario> usuariosordenados= TreeSet<Usuario>();
		
		for(Usuario usuario : usuarios){
			usuariosordenados.add(usuario);
		}
			ModelAndView salida= new ModelAndView("usuarios");
			salida.addObject("usuario", usuariosordenados);
			return salida;
		}
		catch (Exception e){
			
			return new ModelAndView("home");
		}
		
	}
	@RequestMapping("modificaUsuarios.gin")
	public ModelAndView modificaUsuarios(int id)
	{
		if(id==0){
			Usuario usuario=new Usuario()
		}
		else{
			Usuario usuario= getUsuarioDelegate().dameDatos(Usuario.class);
		}
			
		ModelAndView salida= new ModelAndView("modificaUsuario")
		
	}

	public UsuarioDelegate getUsuarioDelegate() {
		return usuarioDelegate;
	}

	public void setUsuarioDelegate(UsuarioDelegate usuarioDelegate) {
		this.usuarioDelegate = usuarioDelegate;
	}

}
