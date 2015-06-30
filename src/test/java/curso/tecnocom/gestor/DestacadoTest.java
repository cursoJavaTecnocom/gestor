package curso.tecnocom.gestor;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import curso.tecnocom.gestor.datos.Contenido;
import curso.tecnocom.gestor.datos.Destacado;
import curso.tecnocom.gestor.datos.Imagene;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("servlet-context.xml")
@FixMethodOrder(MethodSorters.JVM)
public class DestacadoTest {
	
	@Autowired
	private DestacadoController destacadoControler;
	private Destacado destacado;
	
	
	@Test
	public void testDestacado() {

		setDestacado(new Destacado());

		try {
			
			// Se recuperan los objetos Imagen y Contenido
			//Imagene imagen=(Imagene) getDestacadoControler().getGestorDelegate().dameObjeto(1, Imagene.class);
			Contenido contenido=(Contenido) getDestacadoControler().getGestorDelegate().dameObjeto(19,Contenido.class);
			
			// Alta Destacado
			getDestacado().setTexto("Texto Destacado");
			getDestacado().setTitulo("Título Destacado");
			//getDestacado().setImagene(imagen);
			getDestacado().setContenido(contenido);
			
			getDestacadoControler().getGestorDelegate().grabaObjeto(getDestacado());
			//System.out.println(getDestacado());
			
			// Modificación Destacado
			getDestacado().setTexto("Texto modificado");
			getDestacadoControler().getGestorDelegate().grabaObjeto(getDestacado());

			// Borrado Destacado
			getDestacadoControler().getGestorDelegate().borraDato(getDestacado().getId(), Destacado.class);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void listado() {
		try {
			assertNotNull(getDestacadoControler().getGestorDelegate().dameDatos(Destacado.class));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

	public DestacadoController getDestacadoControler() {
		return destacadoControler;
	}

	public void setDestacadoControler(DestacadoController destacadoControler) {
		this.destacadoControler = destacadoControler;
	}

	public Destacado getDestacado() {
		return destacado;
	}

	public void setDestacado(Destacado destacado) {
		this.destacado = destacado;
	}
}
