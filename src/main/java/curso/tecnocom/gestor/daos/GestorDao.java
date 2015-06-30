package curso.tecnocom.gestor.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import curso.tecnocom.gestor.anotaciones.SessionManager;
import curso.tecnocom.gestor.anotaciones.TransactionManager;
import curso.tecnocom.gestor.datos.Principale;

@Component
public class GestorDao  {

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

	//@Override
	@SessionManager
	public List<?> dameDatos(Class<?> clase) throws Exception {
		
		Query q= getSesion().createQuery("from "+clase.getName()+" e");
		//Criteria criteria = getSesion().createCriteria(clase);
		List<?> lista=q.list();
		
		
		return lista;
	}

//	@Override
	@SessionManager
	public Object dameObjeto(int id, Class<?> clase) throws Exception {
		return getSesion().load(clase, id);

	}

	//@Override
	@TransactionManager
	public void grabaDato(Object objeto) throws Exception {
		getSesion().saveOrUpdate(objeto);

	}

	//@Override
	@TransactionManager
	public void borraDato(Object objeto) throws Exception {
		// TODO Auto-generated method stub
		getSesion().delete(objeto);
	}

	//@Override
	@TransactionManager
	public void borraDato(int id, Class<?> clase) throws Exception {
		// TODO Auto-generated method stub
		Object objeto = dameObjeto(id, clase);
		getSesion().delete(objeto);
	}

}
