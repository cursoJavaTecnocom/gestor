package curso.tecnocom.gestor.datos;

import java.beans.PropertyEditorSupport;

public class TipoMenuProperty extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		TipoMenu tm = new TipoMenu();
		tm.setId(Integer.parseInt(text));
		setValue(tm);
	}
}
