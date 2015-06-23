package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DestacadosDao {
	
	/***** Propiedades de la clase *****/
	private Session sesion;
	
	@Autowired
	private SessionFactory factoria;

	
	public List<?> recuperaDatos(Class<?> clase) throws Exception
	{
		
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		
		// Se recuperan los datos de la clase
		Criteria cri=getSesion().createCriteria(clase);
		List<?> datos=cri.list();
		
		return datos;
		
	}
	
	public Object recuperaObjeto(int id, Class<?> clase) throws Exception {
		
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		
		// Se recupera la información del objeto
		return getSesion().load(clase, id);
		
		
	}
	
	
	public void borraObjeto(int id, Class<?> clase) throws Exception{
		
		if (getSesion()==null)
			setSesion(getFactoria().openSession());	
		getSesion().beginTransaction();
		
		getSesion().getTransaction().setTimeout(1);
		
		// Se recupera la información del objeto
		Object objeto=getSesion().load(clase, id);
		getSesion().delete(objeto);
		
		getSesion().getTransaction().commit();
		
	}
	
	
	public void grabaObjeto(Object objeto) throws Exception {
		
		if (getSesion()==null)
			setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		
		getSesion().saveOrUpdate(objeto);
		
		getSesion().getTransaction().commit();

		
	}
	
	
	/***** Métodos Get/Set *****/
	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}

	public SessionFactory getFactoria() {
		return factoria;
	}

	public void setFactoria(SessionFactory factoria) {
		this.factoria = factoria;
	}

	



	
	
	

}
