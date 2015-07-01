package curso.tecnocom.gestor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Principale;
import curso.tecnocom.gestor.delegates.GestorDelegate;








@Controller
public class PrincipalController {

private static final Logger logger = LoggerFactory.getLogger(PrincipalController.class);
	
	// cambio del profesor

	@Autowired
	private GestorDelegate principalDelegate;

	
	
	
	@RequestMapping("principal.html")	
	public ModelAndView principales(HttpServletRequest request) {
		if (!getPrincipalDelegate().validar(request))
			return new ModelAndView("noLogado");
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
	public ModelAndView modificaPrincipal(int id, HttpServletRequest request) {
		if (!getPrincipalDelegate().validar(request))
			return new ModelAndView("noLogado");
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
			return salida;
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}
	}


	
	@RequestMapping("grabaPrincipal.html")
	public ModelAndView grabaPrincipal(Principale principal, HttpServletRequest request) {
		if (!getPrincipalDelegate().validar(request))
			return new ModelAndView("noLogado");
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
	}
	
	
	@RequestMapping("borraPrincipal.html")
	public ModelAndView borraPrincipal(int id, HttpServletRequest request) {
		if (!getPrincipalDelegate().validar(request))
			return new ModelAndView("noLogado");
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
	}
	
	
	
	
	
	
	
	public GestorDelegate getPrincipalDelegate() {
		return principalDelegate;
	}





	public void setPrincipalDelegate(GestorDelegate principalDelegate) {
		this.principalDelegate = principalDelegate;
	}






	
	
	
	
	
	
}
