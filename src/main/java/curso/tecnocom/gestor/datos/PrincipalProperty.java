package curso.tecnocom.gestor.datos;

import java.beans.PropertyEditorSupport;

public class PrincipalProperty extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Principale principal = new Principale();
		principal.setId(Integer.parseInt(text));
		setValue(principal);
	}
}
