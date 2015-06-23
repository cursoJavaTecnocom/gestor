package curso.tecnocom.gestor.datos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the noticias database table.
 * 
 */
@Entity
@Table(name="noticias")
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String fecha;

	@Lob
	private String texto;

	private String titulo;

	//bi-directional many-to-one association to Contenido
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idContenido")
	private Contenido contenido;

	//bi-directional many-to-one association to Imagene
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idImagen")
	private Imagene imagene;

	public Noticia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public Imagene getImagene() {
		return this.imagene;
	}

	public void setImagene(Imagene imagene) {
		this.imagene = imagene;
	}

}