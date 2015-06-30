package curso.tecnocom.gestor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Usuario;
import curso.tecnocom.gestor.delegates.GestorDelegate;

@Controller
public class UsuariosController {

	private static final Logger logger = LoggerFactory
			.getLogger(UsuariosController.class);

	private GestorDelegate usuarioDelegate;
 
	//lista usuarios
	@RequestMapping("usuarios.html") 
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
	
	//modificar
	@RequestMapping("modificaUsuarios.html")
	public ModelAndView modificaUsuarios(int id)
	{
		Usuario usuario = null;
		try {
			if(id==0)
			{
				 usuario=new Usuario();
			}
			else
			{
				 usuario= (Usuario) getUsuarioDelegate().dameDatos(Usuario.class);
			}
			
			ModelAndView salida = new ModelAndView("modificarUsuarios");
			salida.addObject("usuario",usuario);
			return salida;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("home");
		}
			
	}
	
	//borrar
	@RequestMapping("borraUsuarios.html")
	public ModelAndView borraUsuarios(int id)
	{
		try
		{
			getUsuarioDelegate().borraDato(id, Usuario.class);
			return usuarios();
		}
		catch (Exception e){
			return new ModelAndView("home");
		}
		
	}
	
	//grabar usuario
	@RequestMapping("grabaUsuario.html")
	public ModelAndView grabaUsuario(Usuario usuario){
		
		try {
			getUsuarioDelegate().grabaObjeto(usuario);
			return usuarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ModelAndView("error");
		}
	
	}
	
	
	//GETTERS AND SETTERS
	public GestorDelegate getUsuarioDelegate() {
		return usuarioDelegate;
	}

	public void setUsuarioDelegate(GestorDelegate usuarioDelegate) {
		this.usuarioDelegate = usuarioDelegate;
	}

}
