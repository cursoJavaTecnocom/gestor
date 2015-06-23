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
import curso.tecnocom.gestor.delegates.PrincipalDelegate;






@Controller
public class PrincipalController {

private static final Logger logger = LoggerFactory.getLogger(PrincipalController.class);
	
	

	@Autowired
	private PrincipalDelegate principalDelegate;
	
	


	
	
	
	
	@RequestMapping("principal.gin")	
	public ModelAndView principales()
	{
		List<Principale> principales;
		try {
			principales=(List<Principale>)getPrincipalDelegate().dameDatos(Principale.class);
			Set<Principale> principalesOrdenados= new TreeSet<Principale>();
			for (Principale principal : principales) {
				principalesOrdenados.add(principal);
			}
			ModelAndView salida=new ModelAndView("principale");
			salida.addObject("principales", principalesOrdenados);
			return salida;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error") ;
		}
		
		
		
		
	}





	
	
	
	
	
	
	
	
	
	
	
	
	public PrincipalDelegate getPrincipalDelegate() {
		return principalDelegate;
	}





	public void setPrincipalDelegate(PrincipalDelegate principalDelegate) {
		this.principalDelegate = principalDelegate;
	}






	
	
	
	
	
	
}
