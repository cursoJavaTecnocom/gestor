package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class NoticiasDao{
	@Autowired
	private SessionFactory factoria;
	private Session sesion;

	public List<?> dameDatos(Class<?> clase) throws Exception {
		setSesion(getFactoria().openSession());
		Criteria cri = getSesion().createCriteria(clase);
		return cri.list();
	}

	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		setSesion(getFactoria().openSession());
		return getSesion().load(clase, id);
	}
	
	public void borrar(int id, Class<?> clase) throws Exception {
		setSesion(getFactoria().openSession());
		Object gestor = getSesion().load(clase, id);
		getSesion().delete(gestor);
		getSesion().getTransaction().begin();
		getSesion().getTransaction().commit();
	}

	public void modificar(Object mod) throws Exception {
		setSesion(getFactoria().openSession());
		getSesion().getTransaction().begin();
		getSesion().saveOrUpdate(mod);
		getSesion().getTransaction().commit();
	}

	public void grabaObjeto(Object objeto) throws Exception {
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		getSesion().saveOrUpdate(objeto);
		getSesion().getTransaction().commit();		
	}
	
	public SessionFactory getFactoria() {
		return factoria;
	}
	public void setFactoria(SessionFactory sf) {
		this.factoria = sf;
	}
	public Session getSesion() {
		return sesion;
	}
	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}
}
