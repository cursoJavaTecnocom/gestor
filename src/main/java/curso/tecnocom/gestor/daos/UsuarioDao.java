package curso.tecnocom.gestor.daos;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import curso.tecnocom.gestor.anotaciones.SessionManager;
import curso.tecnocom.gestor.datos.Usuario;

public class UsuarioDao extends GestorDao {
	
	//@SessionManager
	public Usuario getUsuarioByUsuario(Usuario usuario) throws Exception
	{
		setSesion(getFactoria().openSession());
		Criteria criUsuarios= getSesion().createCriteria(Usuario.class);
		criUsuarios.add(Restrictions.eqOrIsNull("usuario", usuario.getUsuario()));
		return (Usuario) criUsuarios.uniqueResult();				
	}

}
