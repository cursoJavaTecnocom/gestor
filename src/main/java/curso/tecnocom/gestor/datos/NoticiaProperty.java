package curso.tecnocom.gestor.datos;

import java.beans.PropertyEditorSupport;

public class NoticiaProperty extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Noticia noticia = new Noticia();
		noticia.setId(Integer.parseInt(text));
		setValue(noticia);
	}
}
