package curso.tecnocom.gestor.delegates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import curso.tecnocom.gestor.datos.Usuario;
import curso.tecnocom.gestor.services.UsuarioService;

@Component
public class UsuarioDelegate extends GestorDelegate {

	@Autowired
	private UsuarioService usuarioService;

	public Usuario getUsuarioByUsuario(Usuario usuario) throws Exception
	{
			return getUsuarioService().getUsuarioByUsuario(usuario);
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
