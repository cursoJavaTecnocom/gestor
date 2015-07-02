package curso.tecnocom.gestor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.datos.ContenidoProperty;
import curso.tecnocom.gestor.datos.Imagene;
import curso.tecnocom.gestor.datos.ImagenesProperty;
import curso.tecnocom.gestor.datos.Menu;
import curso.tecnocom.gestor.datos.Noticia;
import curso.tecnocom.gestor.datos.NoticiaProperty;
import curso.tecnocom.gestor.datos.PrincipalProperty;
import curso.tecnocom.gestor.datos.Principale;
import curso.tecnocom.gestor.datos.Usuario;
import curso.tecnocom.gestor.delegates.GestorDelegate;








@Controller
public class PrincipalController {

private static final Logger logger = LoggerFactory.getLogger(PrincipalController.class);
	
	// cambio del profesor

	@Autowired
	private GestorDelegate principalDelegate;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Principale.class, new PrincipalProperty());
		binder.registerCustomEditor(Imagene.class, new ImagenesProperty());
		binder.registerCustomEditor(Contenido.class, new ContenidoProperty());
	}
	
	
	@RequestMapping("principal.html")	
	public ModelAndView principales(HttpServletRequest request) {
		if (!getPrincipalDelegate().validar(request))
		{
			
			ModelAndView modelAndView= new ModelAndView("validacion");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("destino","principal.html");
			return modelAndView;
		}
	{
		List<Principale> principales;
		try {
			principales=(List<Principale>)getPrincipalDelegate().dameDatos(Principale.class);
			Set<Principale> principalesOrdenados= new TreeSet<Principale>();
			for (Principale principal : principales) {
				principalesOrdenados.add(principal);
			}
			ModelAndView salida=new ModelAndView("principal");
			salida.addObject("principales", principalesOrdenados);
			return salida;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error") ;
		}
	}
		
		
		
		
	}



	@RequestMapping("modificaPrincipal.html")
	public ModelAndView modificaPrincipal(int id)
	{
		Principale principal=null;
		if(id==0)
		{
			principal=new Principale();
		}
		
		
		try {
			if(id>0)
			 principal=(Principale) getPrincipalDelegate().dameObjeto(id, Principale.class);			
			ModelAndView salida=new ModelAndView("modificaPrincipal");
			salida.addObject("principal",principal);
			
			List<Imagene> imagenes = (List<Imagene>) getPrincipalDelegate()
					.dameDatos(Imagene.class);
			List<Contenido> contenidos = (List<Contenido>) getPrincipalDelegate()
					.dameDatos(Contenido.class);
			
			
			salida.addObject("imagenes", imagenes);
			salida.addObject("contenidos", contenidos);
			 
			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}



	
	@RequestMapping("grabaPrincipal.html")
	public ModelAndView grabaPrincipal(Principale principal,HttpServletRequest request)
	{
		
		
		try {
			getPrincipalDelegate().grabaObjeto(principal);
			return principales(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		return new ModelAndView("error");
		}
	}

	
	
	@RequestMapping("borraPrincipal.html")
	public ModelAndView borraPrincipal(int id,HttpServletRequest request)
	{
		;
		try {
			getPrincipalDelegate().borraDato(id, Principale.class);
			return principales(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}

	
	
	
	
	
	
	
	public GestorDelegate getPrincipalDelegate() {
		return principalDelegate;
	}





	public void setPrincipalDelegate(GestorDelegate principalDelegate) {
		this.principalDelegate = principalDelegate;
	}






	
	
	
	
	
	
}
