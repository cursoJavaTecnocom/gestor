package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import curso.tecnocom.gestor.anotaciones.SessionManager;
import curso.tecnocom.gestor.anotaciones.TransactionManager;

@Repository
public class GestorDao implements DaoInterface {

	private Session sesion;

	@Autowired
	private SessionFactory factoria;

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

	@Override
	@SessionManager
	public List<?> dameDatos(Class<?> clase) throws Exception {
		Criteria criteria = getSesion().createCriteria(clase);
		return criteria.list();
	}

	@Override
	@SessionManager
	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		return getSesion().load(clase, id);

	}

	@Override
	@TransactionManager
	public void grabaDato(Object objeto) throws Exception {
		getSesion().saveOrUpdate(objeto);

	}

	@Override
	@TransactionManager
	public void borraDato(Object objeto) throws Exception {
		// TODO Auto-generated method stub
		getSesion().delete(objeto);
	}

	@Override
	@TransactionManager
	public void borraDato(int id, Class<?> clase) throws Exception {
		// TODO Auto-generated method stub
		Object objeto = dameObjeto(id, clase);
		getSesion().delete(objeto);
	}

}
