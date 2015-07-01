package curso.tecnocom.gestor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Usuario;
import curso.tecnocom.gestor.delegates.GestorDelegate;

@Controller
public class UsuariosController {

	private static final Logger logger = LoggerFactory
			.getLogger(UsuariosController.class);

	@Autowired
	private GestorDelegate gestorDelegate;
 
	//lista usuarios
	@RequestMapping("usuarios.html")  
	public ModelAndView usuarios()
	{
		try{
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) getGestorDelegate().dameDatos(Usuario.class);
		
			ModelAndView salida= new ModelAndView("usuarios");
			salida.addObject("usuarios", usuarios);
			return salida;
		}
		catch (Exception e){
			e.printStackTrace();
			return new ModelAndView("error");
		}
		
	}
	  
	//modificar
	@RequestMapping("modificaUsuario.html")
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
				 usuario= (Usuario) getGestorDelegate().dameObjeto(id, Usuario.class);
			}
			
			ModelAndView salida = new ModelAndView("modificaUsuarios");
			salida.addObject("usuario",usuario);
			return salida;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}
	
	//borrar
	@RequestMapping("borraUsuarios.html")
	public ModelAndView borraUsuarios(int id)
	{
		try
		{
			getGestorDelegate().borraDato(id, Usuario.class);
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
			getGestorDelegate().grabaObjeto(usuario);
			return usuarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ModelAndView("error");
		}
	
	} 
	
	@RequestMapping("validacion.html")
	public ModelAndView validacion(Usuario usuario, HttpServletRequest request){
		try {
			List<Usuario> usuarios = (List<Usuario>) getGestorDelegate().dameDatos(Usuario.class);
			
			if (usuarios.contains(usuario)) {
				
				request.getSession(true).setAttribute("logado", true);
				return new ModelAndView("principal");
			}
			else
			{
				System.out.println("fallo en logacion");
				return new ModelAndView("validacion");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
		
	}
	
	//GETTERS AND SETTERS
	public GestorDelegate getGestorDelegate() {
		return gestorDelegate;
	}

	public void setGestorDelegate(GestorDelegate gestorDelegate) {
		this.gestorDelegate = gestorDelegate;
	}

}
