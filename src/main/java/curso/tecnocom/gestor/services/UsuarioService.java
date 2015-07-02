package curso.tecnocom.gestor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.UsuarioDao;
import curso.tecnocom.gestor.datos.Usuario;

@Service
public class UsuarioService extends GestorService {

	@Autowired
	private UsuarioDao usuarioDao;

	public Usuario getUsuarioByUsuario(Usuario usuario) throws Exception
	{
			return getUsuarioDao().getUsuarioByUsuario(usuario);
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}