package curso.tecnocom.gestor.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import curso.tecnocom.gestor.datos.Imagene;

@Repository
public class ImagenesDao extends GestorDaoPadre{
	
	public List<Imagene> getImagenesByCarrusel() throws Exception 
	{
		setSesion(getFactoria().openSession());
		Criteria criCarrusel= getSesion().createCriteria(Imagene.class);
		criCarrusel.add(Restrictions.eq("banner",1));
		return criCarrusel.list();
	}

}
