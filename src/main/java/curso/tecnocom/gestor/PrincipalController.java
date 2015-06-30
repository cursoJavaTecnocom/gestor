package curso.tecnocom.gestor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
	public ModelAndView principales()
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
			return salida;
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
	}


	
	@RequestMapping("grabaPrincipal.html")
	public ModelAndView grabaPrincipal(Principale principal)
	{
		
		
		try {
			getPrincipalDelegate().grabaObjeto(principal);
			return principales();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		return new ModelAndView("error");
		}
	}
	
	
	@RequestMapping("borraPrincipal.html")
	public ModelAndView borraPrincipal(int id)
	{
		;
		try {
			getPrincipalDelegate().borrar(id, Principale.class);
			return principales();
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
