package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import curso.tecnocom.gestor.datos.Contenido;

@Repository
public class ContenidoDao extends GestorDaoPadre{
	
	public List<Contenido> getContenidoByContenido() throws Exception 
	{
		setSesion(getFactoria().openSession());
		Criteria criContenido= getSesion().createCriteria(Contenido.class);
		criContenido.add(Restrictions.like("descripcion", "footer"));
		return criContenido.list();
	}

}