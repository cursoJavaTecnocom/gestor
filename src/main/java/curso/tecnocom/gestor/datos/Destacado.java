package curso.tecnocom.gestor.datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the destacados database table.
 * 
 */
@Entity
@Table(name="destacados")
@NamedQuery(name="Destacado.findAll", query="SELECT d FROM Destacado d")
public class Destacado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String texto;

	private String titulo;

	//bi-directional many-to-one association to Contenido
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idContenidos")
	private Contenido contenido;

	
	public Destacado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Contenido getContenido() {
		return this.contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}
	
}