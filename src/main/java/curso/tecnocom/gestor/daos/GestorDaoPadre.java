package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestorDaoPadre implements DaoInterface {

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

	// @Override
	// @SessionManager
	@Override
	public List<?> dameDatos(Class<?> clase) throws Exception {
		setSesion(getFactoria().openSession());

		Criteria criteria = getSesion().createCriteria(clase);
		List<?> lista = criteria.list();

		return lista;
	}

	// @Override
	// @SessionManager
	@Override
	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		setSesion(getFactoria().openSession());

		return getSesion().load(clase, id);

	}

	// @Override
	// @TransactionManager
	@Override
	public void grabaDato(Object objeto) throws Exception {
		if (getSesion() == null || !getSesion().isOpen())
			setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		getSesion().saveOrUpdate(objeto);
		getSesion().getTransaction().commit();

	}

	// @Override
	// @TransactionManager
	@Override
	public void borraDato(Object objeto) throws Exception {
		// TODO Auto-generated method stub
		if (getSesion() == null || !getSesion().isOpen())
			setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		getSesion().delete(objeto);
		getSesion().getTransaction().commit();
	}

	// @Override
	// @TransactionManager
	@Override
	public void borraDato(int id, Class<?> clase) throws Exception {
		// TODO Auto-generated method stub
		setSesion(getFactoria().openSession());
		Object objeto = dameObjeto(id, clase);
		getSesion().beginTransaction();
		getSesion().delete(objeto);
		getSesion().getTransaction().commit();
	}

}
