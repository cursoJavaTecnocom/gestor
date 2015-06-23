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
import curso.tecnocom.gestor.delegates.UsuarioDelegate;

@Controller
public class UsuariosController {

	private static final Logger logger = LoggerFactory
			.getLogger(UsuariosController.class);

	private UsuarioDelegate usuarioDelegate;
 
	@RequestMapping("usuarios.gin") 
	public ModelAndView usuarios()
	{
		try{
		List<Usuario> usuarios = (List<Usuario>) getUsuarioDelegate().dameDatos(Usuario.class);
		Set<Usuario> usuariosordenados= new TreeSet<Usuario>();
		
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
		try {
			if(id==0){
				Usuario usuario=new Usuario();
			}
			else{
				Usuario usuario= (Usuario) getUsuarioDelegate().dameDatos(Usuario.class);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		ModelAndView salida= new ModelAndView("modificaUsuario");
		return salida;
		
	}
//	@RequestMapping("borraUsuarios.gin")
//	public ModelAndView borraUsuarios(int id)
//	{
//		try{
//		getUsuarioDelegate().borrar(id, Usuario.class);
//		return usuarios;}
//		catch (Exception e){
//			
//		}
//		
//	}

	public UsuarioDelegate getUsuarioDelegate() {
		return usuarioDelegate;
	}

	public void setUsuarioDelegate(UsuarioDelegate usuarioDelegate) {
		this.usuarioDelegate = usuarioDelegate;
	}

}
