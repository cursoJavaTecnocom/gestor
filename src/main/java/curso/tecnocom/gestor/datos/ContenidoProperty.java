package curso.tecnocom.gestor.datos;

import java.beans.PropertyEditorSupport;

public class ContenidoProperty extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Contenido contenido = new Contenido();
		contenido.setId(Integer.parseInt(text));
		setValue(contenido);
	}
}
