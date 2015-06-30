package curso.tecnocom.gestor.daos;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface DaoInterface {
	
	public List<?> dameDatos(Class<?> clase) throws Exception;
	public Object dameObjeto(int id,Class<?> clase) throws Exception;
	public void grabaDato(Object objeto) throws Exception;
	public void borraDato(Object objeto) throws Exception;
	public void borraDato(int id,Class<?> clase) throws Exception;
}
