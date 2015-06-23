package curso.tecnocom.gestor.datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the datosGlobales database table.
 * 
 */
@Entity
@Table(name="datosGlobales")
@NamedQuery(name="DatosGlobale.findAll", query="SELECT d FROM DatosGlobale d")
public class DatosGlobale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String contenido;

	private String descripcion;

	public DatosGlobale() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}