package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PrincipalDao {

	
	private Session sesion;
	
	@Autowired
	private SessionFactory factoria;

	
	
	public List<?> dameDatos(Class<?> clase) throws Exception
	{
		
		if(getSesion()==null)
			setSesion(getFactoria().openSession());
		
		Criteria cri= getSesion().createCriteria(clase);
		List<?> datos=cri.list();
		return cri.list();
		
	}
	
	
	public Object dameObjeto(int id, Class<?> clase) throws Exception
	{
		
		if(getSesion()==null)
			setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		return getSesion().load(clase, id);
		
	}
	
	public void grabaObjeto(Object objeto)
	{
		if(getSesion()==null);
		setSesion(getFactoria().openSession());
			getSesion().beginTransaction();
		getSesion().saveOrUpdate(objeto);
		getSesion().getTransaction().commit();
	}
	
	
	public void borrar(int id, Class<?> clase) throws Exception{
		if(getSesion()==null);
		setSesion(getFactoria().openSession());
			getSesion().beginTransaction();
		
		Object objeto= getSesion().load(clase, id);
		getSesion().delete(objeto);
		try {
			getSesion().getTransaction().commit();
		} catch (ConstraintViolationException e){
			getSesion().getTransaction().rollback();
		}
		finally{
			getSesion().flush();
		}
	}
	
	
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
