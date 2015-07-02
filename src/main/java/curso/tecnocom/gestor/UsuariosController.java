package curso.tecnocom.gestor;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Usuario;
import curso.tecnocom.gestor.delegates.GestorDelegate;
import curso.tecnocom.gestor.delegates.UsuarioDelegate;

@Controller
public class UsuariosController {

	private static final Logger logger = LoggerFactory
			.getLogger(UsuariosController.class);

	@Autowired
	private GestorDelegate gestorDelegate;
	@Autowired
	private UsuarioDelegate usuarioDelegate;
	@Autowired
	private ServletContext servletContext;

	// lista usuarios
	@RequestMapping("usuarios.html")
	public ModelAndView usuarios(HttpServletRequest request) {

		if (!gestorDelegate.validar(request)) {

			ModelAndView modelAndView = new ModelAndView("validacion");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("destino", "usuarios.html");
			return modelAndView;
		}
 
		try {
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) getGestorDelegate()
					.dameDatos(Usuario.class);

			ModelAndView salida = new ModelAndView("usuarios");
			salida.addObject("usuarios", usuarios);
			return salida;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	// modificar
	@RequestMapping("modificaUsuario.html")
	public ModelAndView modificaUsuarios(int id, HttpServletRequest request) {
		// if(!gestorDelegate.validar(request))
		// return new ModelAndView("noLogado");

		Usuario usuario = null;
		try {
			if (id == 0) {
				usuario = new Usuario();
			} else {
				usuario = (Usuario) getGestorDelegate().dameObjeto(id,
						Usuario.class);
			}

			ModelAndView salida = new ModelAndView("modificaUsuarios");
			salida.addObject("usuario", usuario);
			return salida;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}

	}

	// borrar
	@RequestMapping("borraUsuario.html")
	public ModelAndView borraUsuarios(int id, HttpServletRequest request) {
		// if(!gestorDelegate.validar(request))
		// return new ModelAndView("noLogado");
		try {
			getGestorDelegate().borraDato(id, Usuario.class);
			return usuarios(request);
		} catch (Exception e) {
			return new ModelAndView("home");
		}

	}

	// grabar usuario
	@RequestMapping("grabaUsuario.html")
	public ModelAndView grabaUsuario(Usuario usuario, HttpServletRequest request) {

		// if(!gestorDelegate.validar(request))
		// return new ModelAndView("noLogado");
		try {
			getGestorDelegate().grabaObjeto(usuario);
			return usuarios(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ModelAndView("error");
		}

	}

	// Validar
	@RequestMapping("validacion.html")
	public ModelAndView validacion(Usuario usuario, HttpServletRequest request, HttpServletResponse response,
			String destino) {
		try {

			String claveIntroducida = usuario.getClave();

			Usuario usuarioRecuperado = getUsuarioDelegate()
					.getUsuarioByUsuario(usuario);

			String claveRecuperada = usuarioRecuperado.getClave();

			if (claveIntroducida.equals(claveRecuperada)) {

				request.getSession(true).setAttribute("logado", true);
				getServletContext().getRequestDispatcher("/"+destino).forward(request, response);
				return null;

			} else {
				System.out.println("fallo en logacion");
				return new ModelAndView("validacion");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("validacion");
		}

	}
	@RequestMapping("cerrarSesion.html")
	public ModelAndView cerrarSesion(HttpServletRequest request){
		try {
			//request.getSession(true).setAttribute("logado", false);
			request.getSession().invalidate();
			return new ModelAndView("index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		} 
	
	}
	

	// GETTERS AND SETTERS
	public GestorDelegate getGestorDelegate() {
		return gestorDelegate;
	}

	public void setGestorDelegate(GestorDelegate gestorDelegate) {
		this.gestorDelegate = gestorDelegate;
	}

	public UsuarioDelegate getUsuarioDelegate() {
		return usuarioDelegate;
	}

	public void setUsuarioDelegate(UsuarioDelegate usuarioDelegate) {
		this.usuarioDelegate = usuarioDelegate;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
