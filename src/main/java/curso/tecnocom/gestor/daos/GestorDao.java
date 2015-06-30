package curso.tecnocom.gestor.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import curso.tecnocom.gestor.anotaciones.SessionManager;
import curso.tecnocom.gestor.anotaciones.TransactionManager;
import curso.tecnocom.gestor.datos.Principale;

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
	//@SessionManager
	public List<?> dameDatos(Class<?> clase) throws Exception {
		setSesion(getFactoria().openSession());
		Criteria criteria = getSesion().createCriteria(clase);
		List<?> lista=criteria.list();
		List<Principale> lista1=  new ArrayList<Principale>();
		for (Object object : lista) {
			lista1.add((Principale) object);
			
		}
		getSesion().close();
		return lista1;
	}

	@Override
	//@SessionManager
	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		setSesion(getFactoria().openSession());
		return getSesion().load(clase, id);

	}

	@Override
	//@TransactionManager
	public void grabaDato(Object objeto) throws Exception {
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		getSesion().saveOrUpdate(objeto);
		getSesion().getTransaction().commit();
	}

	@Override
	//@TransactionManager
	public void borraDato(Object objeto) throws Exception
	{
		// TODO Auto-generated method stub
		
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		getSesion().delete(objeto);
		getSesion().getTransaction().commit();
	}

	@Override
	//@TransactionManager
	public void borraDato(int id, Class<?> clase) throws Exception {
		// TODO Auto-generated method stub
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		Object objeto = dameObjeto(id, clase);
		getSesion().delete(objeto);
		getSesion().getTransaction().commit();
	}

}
