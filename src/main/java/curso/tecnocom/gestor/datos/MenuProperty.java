package curso.tecnocom.gestor.datos;

import java.beans.PropertyEditorSupport;

public class MenuProperty extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Menu menu = new Menu();
		menu.setId(Integer.parseInt(text));
		setValue(menu);
	}
}
