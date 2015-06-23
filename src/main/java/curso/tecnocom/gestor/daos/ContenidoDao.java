package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ContenidoDao {

	@Autowired
	private Session sesion;
	
	private SessionFactory factoria;
	
	public List<?> dameDatos(Class<?> clase) throws Exception{
		
		setSesion(getFactoria().openSession());
		Criteria cri = getSesion().createCriteria(clase);
		List<?> datos=cri.list();
		
		return datos;
	}
	
	public Object dameObjeto(int id, Class<?> clase) {
		
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		
		return getSesion().load(clase, id);
	}
	
	public void grabaObjeto(Object objeto) {
		if (getSesion()==null)
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		
		getSesion().saveOrUpdate(objeto);
		getSesion().getTransaction().commit();
	}
	

	public SessionFactory getFactoria() {
		return factoria;
	}

	public void setFactoria(SessionFactory factoria) {
		this.factoria = factoria;
	}

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}
	
}
