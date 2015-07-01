package curso.tecnocom.gestor.datos;

import java.beans.PropertyEditorSupport;

public class ContenidoProperty extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Contenido contenido = new Contenido();
		try {
			contenido.setId(Integer.parseInt(text));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			contenido.setId(0);
		}
		setValue(contenido);
	}
}
