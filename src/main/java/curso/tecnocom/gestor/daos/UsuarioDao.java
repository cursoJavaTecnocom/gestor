package curso.tecnocom.gestor.daos;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import curso.tecnocom.gestor.anotaciones.SessionManager;
import curso.tecnocom.gestor.datos.Usuario;

@Repository
public class UsuarioDao extends GestorDaoPadre {
	
	//@SessionManager
	public Usuario getUsuarioByUsuario(Usuario usuario) throws Exception
	{
		setSesion(getFactoria().openSession());
		Criteria criUsuarios= getSesion().createCriteria(Usuario.class);
		criUsuarios.add(Restrictions.eqOrIsNull("usuario", usuario.getUsuario()));
		return (Usuario) criUsuarios.uniqueResult();				
	}

}
