package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao {

	private Session sesion;
	
	@Autowired
	private SessionFactory factoria;
		
	//GRABAR OBJETO
	
	public void grabaObjeto(Object objeto) throws Exception {
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		getSesion().saveOrUpdate(objeto);
		getSesion().getTransaction().commit();		
	}
		
	//COGER LISTA DATOS
	
	public List <?> dameDatos(Class<?> clase) {
		
		setSesion(getFactoria().openSession());		
		Criteria cri = getSesion().createCriteria(clase);
		List<?> datos = cri.list();
		
		return  datos;
	}

	//DAME OBJETO
	
	public Object dameObjeto(int id, Class<?> class1) throws Exception{
		
		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		return getSesion().load(class1, id);
	}
	
	//BORRAR
	
	public void borrar(int id, Class<?> clase) throws Exception {

		setSesion(getFactoria().openSession());
		getSesion().beginTransaction();
		
		Object objeto = getSesion().load(clase, id);
		getSesion().delete(objeto);

		getSesion().getTransaction().commit();
	
	}
	
	//GETTERS AND SETTERS
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
