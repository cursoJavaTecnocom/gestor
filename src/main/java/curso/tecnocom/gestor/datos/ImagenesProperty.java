package curso.tecnocom.gestor.datos;

import java.beans.PropertyEditorSupport;

public class ImagenesProperty extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Imagene imagen = new Imagene();
		imagen.setId(Integer.parseInt(text));
		setValue(imagen);
	}
}
