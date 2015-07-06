package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import curso.tecnocom.gestor.datos.Contenido;

@Repository
public class ContenidoDao extends GestorDaoPadre{
	
	public List<Contenido> getContenidoFooter() throws Exception 
	{
		setSesion(getFactoria().openSession());
		Criteria criContenidoFooter= getSesion().createCriteria(Contenido.class);
		criContenidoFooter.add(Restrictions.like("descripcion", "footer"));
		return criContenidoFooter.list();
	}
	
	public List<Contenido> getContenidoHeader() throws Exception 
	{
		setSesion(getFactoria().openSession());
		Criteria criContenidoHeader= getSesion().createCriteria(Contenido.class);
		criContenidoHeader.add(Restrictions.like("descripcion", "header"));
		return criContenidoHeader.list();
	}

	
	

}