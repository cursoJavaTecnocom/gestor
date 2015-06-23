package curso.tecnocom.gestor.delegates;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.tecnocom.gestor.services.PrincipalService;





	@Component
	public class PrincipalDelegate {
		
		@Autowired
		private PrincipalService principalService;
		

		
		
		public List<?> dameDatos(Class clase) throws Exception
		{
			return getPrincipalService().dameDatos(clase);
		
		}


		





		public void borrar(int id, Class<?> clase)throws Exception{
			
			getPrincipalService().borrar(id,clase);
		}
		
		public Object dameObjeto(int id, Class<?> clase) throws Exception
		{
			return getPrincipalService().dameObjeto(id,clase);
		}


		public void grabaObjeto(Object objeto) throws Exception {
			// TODO Auto-generated method stub
			getPrincipalService().grabaObjeto(objeto);
			
		}
	
	
		
		
		
		
		
		public PrincipalService getPrincipalService() {
			return principalService;
		}




		public void setPrincipalService(PrincipalService principalService) {
			this.principalService = principalService;
		}
		
		
	
}
